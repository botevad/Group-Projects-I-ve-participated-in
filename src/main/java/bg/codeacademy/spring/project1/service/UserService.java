package bg.codeacademy.spring.project1.service;

import bg.codeacademy.spring.project1.model.User;

import java.util.List;

public interface UserService
{
  void addUser(User user);
  User getUser(Integer id);

  void editUserByUsername(Integer id, String username);

  List<User> getAllUsers();
}
