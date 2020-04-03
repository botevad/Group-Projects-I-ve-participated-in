package bg.codeacademy.spring.project1.config;

import bg.codeacademy.spring.project1.model.User;
import bg.codeacademy.spring.project1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter
{
  //Configuration to be finished by Zornitsa Dimova

  @Override
  protected void configure(HttpSecurity http) throws Exception
  {
    //Needs to be implemented by Zornitsa Dimova
    http
        .authorizeRequests()
        .antMatchers(HttpMethod.GET, "/api/v1/**").hasAnyRole("FRIEND", "ADMIN") // define access control
        .antMatchers(HttpMethod.PUT, "/api1/v1/**").hasRole("ADMIN")
        .antMatchers(HttpMethod.POST, "/api1/v1/**").hasRole("ADMIN")
        .antMatchers(HttpMethod.PATCH, "/api1/v1/**").hasRole("ADMIN")
        .antMatchers(HttpMethod.DELETE, "/api1/v1/**").hasRole("ADMIN")
        .and()
        .httpBasic();

    // TODO do we need this?
    http.csrf().disable();
    http.headers().frameOptions().disable();
  }

  @Bean
  PasswordEncoder passwordEncoder()
  {
    return new BCryptPasswordEncoder();
  }

  @Bean
  @Override
  public UserDetailsService userDetailsService()
  {
    return new UserDetailsService()
    {

      @Autowired
      private UserRepository userRepo;

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
            builder.password(passwordEncoder().encode(user.getPassword()));
            builder.roles("ADMIN"); // TODO how to get the roles?
            return builder.build();
          }
        }
        throw new UsernameNotFoundException("User not found.");
      }
    };
  }
}
