package bg.codeacademy.spring.project1.controller;

import bg.codeacademy.spring.project1.dto.UserDTO;
import bg.codeacademy.spring.project1.model.User;
import bg.codeacademy.spring.project1.service.UserService;
import bg.codeacademy.spring.project1.service.UserServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController
{
  private final UserService userService;

  @Autowired
  public UserController(UserService userService)
  {
    this.userService = userService;
  }

  @PostMapping
  public void addUser(@Valid @RequestBody UserDTO userDto)
  {
    userService.addUser(UserService.fromDto(userDto));
  }

  @GetMapping
  List<UserDTO> getAll()
  {
    return userService.getAllUsers().stream().
        map(user -> UserService.toDto(user)).collect(Collectors.toList());
  }

  public User getUserById(Integer userId)
  {
    return userService.getUser(userId);
  }
}
