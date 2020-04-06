package bg.codeacademy.spring.project1.service;

import bg.codeacademy.spring.project1.dto.ChangePasswordDTO;
import bg.codeacademy.spring.project1.dto.UserDTO;
import bg.codeacademy.spring.project1.dto.UserRegistration;
import bg.codeacademy.spring.project1.model.User;

import java.util.List;

public interface UserService
{

  User getUserByUsername(String userName);

  void createUser(User user);

  boolean changePassword(String userName, String password);

  // boolean deleteUser(String userName);

  List<User> getUsers();

  User getUser(Integer id);
}
