package bg.codeacademy.spring.project1.service;

import bg.codeacademy.spring.project1.dto.ChangePasswordDto;
import bg.codeacademy.spring.project1.dto.UserDTO;
import bg.codeacademy.spring.project1.dto.UserRegistration;
import bg.codeacademy.spring.project1.enums.Role;
import bg.codeacademy.spring.project1.model.User;
import bg.codeacademy.spring.project1.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class UserServiceImpl implements UserService
{

  private final PasswordEncoder passwordEncoder;

  private final UserRepository userRepo;

  public UserServiceImpl(PasswordEncoder passwordEncoder, UserRepository userRepo)
  {
    this.passwordEncoder = passwordEncoder;
    this.userRepo = userRepo;
  }

  public User getUser(String userName)
  {
    User user = userRepo.findUserByUsername(userName);
    if (user.getUsername().equals(userName)) {
      if (user.isEnabled()) {
        return user;
      }
      else {
        return null;
      }
    }
    return null;
  }

  @Override
  public void createUser(String username, String password, Role role)
  {
    User user = new User(true);
    user.setUsername(username);
    user.setRole(role);
    user.setPassword(passwordEncoder.encode(password));
    userRepo.saveAndFlush(user);
  }

  @Override
  public boolean changePassword(String userName, String oldPassword, String newPassword)
  {
    User user = getUser(userName);
    if (user != null && user.isEnabled()) {
      if (new BCryptPasswordEncoder().matches(oldPassword, user.getPassword())) {
        user.setPassword(passwordEncoder.encode(newPassword));
        userRepo.saveAndFlush(user);
        return true;
      }
    }
    return false;
  }

  @Override
  public boolean deleteUser(String userName)
  {
    User user = getUser(userName);
    if (user != null) {
      user.setEnabled(false);
      userRepo.saveAndFlush(user);
      return true;
    }
    return false;
  }

  @Override
  public List<User> getUsers()
  {
    List<User> users = userRepo.findAll();
    Iterator<User> i = users.iterator();
    while (i.hasNext()) {
      User user = i.next();
      if (!user.isEnabled()) {
        i.remove();
      }
    }
    return users;
  }

  @Override
  public User getUser(Integer id)
  {
    return userRepo.getOne(id);
  }
}
