package bg.codeacademy.spring.project1.service;

import bg.codeacademy.spring.project1.model.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService
{
  void addUser(User u);

  List<User> getAllUsers();

  User getUser(Integer id);
}
