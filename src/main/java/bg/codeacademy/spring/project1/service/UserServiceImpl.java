package bg.codeacademy.spring.project1.service;

import bg.codeacademy.spring.project1.model.User;
import bg.codeacademy.spring.project1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepo;

    @Autowired
    public UserServiceImpl(UserRepository userRepo) {
        this.userRepo = userRepo;
    }


    @Override
    public User getUserByUsername(String userName) {
        List<User> users = userRepo.findAll();
        for (User user : users) {
            if (user.getUsername().equals(userName)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public void createUser(User user) {

        userRepo.saveAndFlush(user);
    }

    @Override
    public boolean changePassword(String userName, String password) {
      User user = getUserByUsername(userName);
      if (user != null) {
        if (password.equals(user.getPassword())) {
          return false;
        }
        user.setPassword(password);
        return true;
      }
      return false;
    }



 /* @Override
  public boolean deleteUser(String userName)
  {
    User user = getUserEntity(userName);
    if (user != null) {
      userRepo.delete(user);
      return true;
    }
    return false;
  } */

        @Override
        public List<User> getUsers () {
            List<User> users = userRepo.findAll();


            return users;
        }

        @Override
        public User getUser (Integer id){
            return userRepo.getOne(id);
        }
    }
