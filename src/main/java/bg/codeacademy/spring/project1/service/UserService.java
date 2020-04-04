package bg.codeacademy.spring.project1.service;

import bg.codeacademy.spring.project1.dto.ChangePasswordDto;
import bg.codeacademy.spring.project1.dto.UserDto;
import bg.codeacademy.spring.project1.dto.UserRegistration;

import java.util.List;

public interface UserService
{

  enum ChangePasswordResult {
    OK, NOT_FOUND, BAD_CREDENTIALS
  }

  public UserDto getUser(String userName);

  public void createUser(UserRegistration userDto);

  public ChangePasswordResult changePassword(String userName, ChangePasswordDto changePasswordDto);

  public boolean deleteUser(String userName);

  public List<UserDto> getUsers();
}

