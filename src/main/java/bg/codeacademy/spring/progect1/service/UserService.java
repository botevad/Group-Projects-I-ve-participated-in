package bg.codeacademy.spring.progect1.service;

import bg.codeacademy.spring.progect1.model.User;

public interface UserService
{
  void addUser(User user);
  User getUser(Integer id);
  void editUserByUsername(Integer id, String username);
}
