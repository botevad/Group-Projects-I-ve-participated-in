package bg.codeacademy.spring.project1.service;

import bg.codeacademy.spring.project1.dto.UserDTO;
import bg.codeacademy.spring.project1.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService
{
  void addUser(User u);

  List<User> getAllUsers();

  User getUser(Integer id);

  static User fromDto(UserDTO userDto)
  {
    User user = new User();
    BeanUtils.copyProperties(userDto, user);

    return user;
  }

  static UserDTO toDto(User user)
  {
    UserDTO userDto = new UserDTO();
    BeanUtils.copyProperties(user, userDto);

    return userDto;
  }
}
