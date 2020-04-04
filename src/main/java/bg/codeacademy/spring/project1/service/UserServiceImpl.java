package bg.codeacademy.spring.project1.service;

import bg.codeacademy.spring.project1.model.User;
import bg.codeacademy.spring.project1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService
{
  @Autowired
  private UserRepository userRepository;

  @Override
  public void addUser(User user)
  {
    userRepository.save(user);
  }

  @Override
  public User getUser(Integer id)
  {
    return userRepository.findById(id).get();
  }

  public void editUserByUsername(Integer id, String username)
  {
    /* TO-DO */
  }

  @Override
  public List<User> getAllUsers()
  {
    return userRepository.findAll();
  }

}
