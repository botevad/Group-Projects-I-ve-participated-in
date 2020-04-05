package bg.codeacademy.spring.project1.controller;

import bg.codeacademy.spring.project1.dto.ChangePasswordDTO;
import bg.codeacademy.spring.project1.dto.UserDTO;
import bg.codeacademy.spring.project1.dto.UserRegistration;
import bg.codeacademy.spring.project1.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UsersController
{

  private final UserService userService;

  public UsersController(UserService userService)
  {
    this.userService = userService;
  }

  @RequestMapping(method = RequestMethod.GET)
  public List<UserDTO> getUsers()
  {
    return userService.getUsers();
  }

  @RequestMapping(method = RequestMethod.GET, value = "/{user}")
  public ResponseEntity<?> getUser(@PathVariable("user") String userName)
  {
    UserDTO userDto = userService.getUser(userName);
    if (userDto == null) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    return ResponseEntity.ok(userDto);
  }

  @RequestMapping(method = RequestMethod.PUT)
  public ResponseEntity<?> createUser(@RequestBody() UserRegistration userRegistration)
  {
    if (userService.getUser(userRegistration.username) != null) {
      return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
    }
    userService.createUser(userRegistration);
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

  @RequestMapping(method = RequestMethod.DELETE, value = "/{user}")
  public ResponseEntity<?> deleteUser(@PathVariable("user") String userName)
  {
    if (userService.deleteUser(userName)) {
      return ResponseEntity.ok().build();
    }
    return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
  }

  @RequestMapping(method = RequestMethod.POST, value = "/{user}/password")
  public @ResponseBody
  ResponseEntity<?> changePassword(@PathVariable("user") String userName, @RequestBody ChangePasswordDTO changePasswordDto, Principal principal)
  {
    if (!userName.equals(principal.getName())) {
      return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Wrong User");
    }
    switch (userService.changePassword(userName, changePasswordDto)) {
      case OK:
        return ResponseEntity.ok().build();
      case BAD_CREDENTIALS:
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Wrong Password");
      case NOT_FOUND:
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    return null; // just to compile
  }
}
