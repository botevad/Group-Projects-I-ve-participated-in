package bg.codeacademy.spring.project1.service;

import bg.codeacademy.spring.project1.dto.ChangePasswordDTO;
import bg.codeacademy.spring.project1.dto.UserDTO;
import bg.codeacademy.spring.project1.dto.UserRegistration;

import java.util.List;

public interface UserService
{

  enum ChangePasswordResult {
    OK, NOT_FOUND, BAD_CREDENTIALS
  }

  public UserDTO getUser(String userName);

  public void createUser(UserRegistration userDto);

  public ChangePasswordResult changePassword(String userName, ChangePasswordDTO changePasswordDto);

  public boolean deleteUser(String userName);

  public List<UserDTO> getUsers();
}
