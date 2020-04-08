package bg.codeacademy.spring.project1.service;


import bg.codeacademy.spring.project1.dto.ChangePasswordDto;
import bg.codeacademy.spring.project1.dto.UserDTO;
import bg.codeacademy.spring.project1.dto.UserRegistration;
import bg.codeacademy.spring.project1.enums.Role;
import bg.codeacademy.spring.project1.model.User;

import java.util.List;

public interface UserService
{

  User getUser(String userName);

  void createUser(String userName, String password, Role role);

  boolean changePassword(String userName, String oldPassword, String newPassword);

  boolean deleteUser(String userName);

  List<User> getUsers();

  User getUser(Integer id);
}
