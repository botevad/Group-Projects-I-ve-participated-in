package bg.codeacademy.spring.project1.service;

import bg.codeacademy.spring.project1.dto.ChangePasswordDto;
import bg.codeacademy.spring.project1.dto.UserDTO;
import bg.codeacademy.spring.project1.dto.UserRegistration;
import bg.codeacademy.spring.project1.model.User;
import bg.codeacademy.spring.project1.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService
{

  private final UserRepository userRepo;

  public UserServiceImpl(UserRepository userRepo)
  {
    this.userRepo = userRepo;
  }

  private User getUserEntity(String userName)
  {
    List<User> users = userRepo.findAll();
    for (User user : users) {
      if (user.getUsername().equals(userName)) {
        return user;
      }
    }
    return null;
  }

  @Override
  public UserDTO getUser(String userName)
  {
    User user = getUserEntity(userName);
    if (user != null) {
      UserDTO userDto = new UserDTO();
      userDto.username = userName;
      return userDto;
    }
    return null;
  }

  @Override
  public void createUser(UserRegistration userDto)
  {
    User user = new User(true);
    user.setUsername(userDto.username);
    user.setRole(userDto.role);
    user.setPassword(new BCryptPasswordEncoder().encode(userDto.password));
    userRepo.saveAndFlush(user);
  }

  @Override
  public boolean changePassword(String userName, ChangePasswordDto changePasswordDto)
  {
    User user = getUserEntity(userName);
    if (user != null) {
      if (new BCryptPasswordEncoder().matches(changePasswordDto.oldPassword, user.getPassword())) {
        user.setPassword(new BCryptPasswordEncoder().encode(changePasswordDto.newPassword));
        userRepo.saveAndFlush(user);
        return true;
      }
    }
    return false;
  }

  @Override
  public boolean deleteUser(String userName)
  {
    User user = getUserEntity(userName);
    if (user != null) {
      userRepo.delete(user);
      return true;
    }
    return false;
  }

  @Override
  public List<UserDTO> getUsers()
  {
    List<User> users = userRepo.findAll();
    List<UserDTO> userDtos = new ArrayList<>();
    for (User user : users) {
      UserDTO userDto = new UserDTO();
      userDto.username = user.getUsername();
      userDtos.add(userDto);
    }

    return userDtos;
  }
  public List<UserRegistration> getUserRegistration()
  {
    List<User> users = userRepo.findAll();
    List<UserRegistration> userRegistrations = new ArrayList<>();
    for (User user : users) {
      UserRegistration userRegistration = new UserRegistration();
      userRegistration.username = user.getUsername();
      userRegistration.password = user.getPassword();
      userRegistration.role = user.getRole();
      userRegistrations.add(userRegistration);
    }

    return userRegistrations;
  }

  @Override
  public User getUser(Integer id)
  {
    return userRepo.getOne(id);
  }
}