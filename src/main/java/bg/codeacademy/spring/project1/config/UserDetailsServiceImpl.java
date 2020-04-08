package bg.codeacademy.spring.project1.config;

import bg.codeacademy.spring.project1.enums.Role;
import bg.codeacademy.spring.project1.model.User;
import bg.codeacademy.spring.project1.repository.UserRepository;
import bg.codeacademy.spring.project1.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

public class UserDetailsServiceImpl implements UserDetailsService
{

  private UserService userService;

  public UserDetailsServiceImpl(UserService userService)
  {
    this.userService = userService;
  }

  @Override
  public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException
  {
    List<User> users = userService.getUsers();
    if (users.isEmpty()) {
      // first start, create default admin user
      User admin = new User(true);
      admin.setUsername("admin");
      admin.setRole(Role.ADMIN);
      admin.setPassword(new BCryptPasswordEncoder().encode("123456"));
      userService.createUser(admin.getUsername(),admin.getPassword(),admin.getRole());
      users.add(admin);
    }
    for (bg.codeacademy.spring.project1.model.User user : users) {
      if (user.getUsername().equals(userName)) {
        org.springframework.security.core.userdetails.User.UserBuilder builder = null;
        builder = org.springframework.security.core.userdetails.User.withUsername(userName);
        builder.password(user.getPassword());
        builder.roles(user.getRole().toString());
        return builder.build();
      }
    }
    throw new UsernameNotFoundException("User not found.");
  }
}
