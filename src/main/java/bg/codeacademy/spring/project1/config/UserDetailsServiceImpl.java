package bg.codeacademy.spring.project1.config;

import bg.codeacademy.spring.project1.model.User;
import bg.codeacademy.spring.project1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

public class UserDetailsServiceImpl implements UserDetailsService
{

  private UserRepository userRepo;

  public UserDetailsServiceImpl(UserRepository userRepo)
  {
    this.userRepo = userRepo;
  }

  @Override
  public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException
  {
    List<User> users = userRepo.findAll();
    if (users.isEmpty()) {
      // first start, create default admin user
      User admin = new User(true);
      admin.setUsername("admin");
      admin.setPassword("123456");
      userRepo.saveAndFlush(admin);
      users.add(admin);
    }
    for (bg.codeacademy.spring.project1.model.User user : users) {
      if (user.getUsername().equals(userName)) {
        org.springframework.security.core.userdetails.User.UserBuilder builder = null;
        builder = org.springframework.security.core.userdetails.User.withUsername(userName);
        builder.password(new BCryptPasswordEncoder().encode(user.getPassword()));
        builder.roles("ADMIN"); // TODO how to get the roles?
        return builder.build();
      }
    }
    throw new UsernameNotFoundException("User not found.");
  }
}
