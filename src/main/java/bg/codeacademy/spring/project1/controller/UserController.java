package bg.codeacademy.spring.project1.controller;

import bg.codeacademy.spring.project1.dto.ChangePasswordDto;
import bg.codeacademy.spring.project1.dto.UserDTO;
import bg.codeacademy.spring.project1.dto.UserRegistration;
import bg.codeacademy.spring.project1.model.User;
import bg.codeacademy.spring.project1.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Validated
@RestController
@RequestMapping("/api/v1/users")
public class UserController
{

  private final UserService userService;

  public UserController(UserService userService)
  {
    this.userService = userService;
  }

  @GetMapping
  public List<UserDTO> getUsers() {
    List<User> users = userService.getUsers();
    List<UserDTO> userDtos = new ArrayList<>();
    for (User user : users) {
      UserDTO userDto = new UserDTO();
      userDto.username = user.getUsername();
      userDtos.add(userDto);
    }

    return userDtos;
  }

  @GetMapping(value = "/{user}")
  public ResponseEntity<UserDTO> getUser(@PathVariable("user") String userName)
  {
    User user = userService.getUser(userName);
    if (user != null) {
      UserDTO userDto = new UserDTO();
      userDto.username = userName;
      return ResponseEntity.ok(userDto);
    }
    return ResponseEntity.notFound().build();
  }

  @PutMapping
  public ResponseEntity<?> createUser(@Valid @RequestBody() UserRegistration userRegistration) throws URISyntaxException
  {
    if (userService.getUser(userRegistration.username) != null) {
      return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }
    userService.createUser(userRegistration.username, userRegistration.password, userRegistration.role);
    return ResponseEntity.created(new URI("/users/" + userRegistration.username)).build();
  }

  @DeleteMapping(value = "/{user}")
  public ResponseEntity<?> deleteUser(@PathVariable("user") String userName)
  {
    if (userService.deleteUser(userName)) {
      return ResponseEntity.ok().build();
    }
    return ResponseEntity.notFound().build();
  }

  @PostMapping(value = "/{user}/password")
  public @ResponseBody
  ResponseEntity<?> changePassword(@PathVariable("user") String userName, @Valid @RequestBody ChangePasswordDto changePasswordDto, Principal principal)
  {
    if (!userName.equals(principal.getName()) || !userService.changePassword(userName, changePasswordDto.oldPassword, changePasswordDto.newPassword)) {
      return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Wrong password or user name");
    }
    return ResponseEntity.ok().build();
  }
}
