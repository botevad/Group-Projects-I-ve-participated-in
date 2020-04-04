package bg.codeacademy.spring.project1.service;

import bg.codeacademy.spring.project1.dto.UserDTO;
import bg.codeacademy.spring.project1.model.User;
import bg.codeacademy.spring.project1.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService
{
  private final UserRepository userRepository;

  @Autowired
  public UserServiceImpl(UserRepository userRepository)
  {
    this.userRepository = userRepository;
  }

  @Override
  public void addUser(User u)
  {
    userRepository.save(u);
  }

  @Override
  public List<User> getAllUsers()
  {
    return userRepository.findAll();
  }

  @Override
  public User getUser(Integer id)
  {
    return userRepository.getOne(id);
  }
}
