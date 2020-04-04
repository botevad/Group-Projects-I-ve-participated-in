package bg.codeacademy.spring.project1.controller;

import bg.codeacademy.spring.project1.model.User;
import bg.codeacademy.spring.project1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController
{
  @Autowired
  UserService userService;

  @PostMapping
  public void addUser(@RequestBody User u)
  {
    //check if user exist in date base
    userService.addUser(u);
  }

  @GetMapping
  List<User> getAll()
  {
    return userService.getAllUsers();
  }

  public User getUserById(Integer userId)
  {
    return userService.getUser(userId);
  }
}
