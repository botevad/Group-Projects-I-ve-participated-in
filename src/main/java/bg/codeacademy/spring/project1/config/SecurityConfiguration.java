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
  private UserRepository userRepo;

  public SecurityConfiguration(UserRepository userRepo)
  {
    this.userRepo = userRepo;
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception
  {
    //Needs to be implemented by Zornitsa Dimova
    http
        .authorizeRequests()
        .antMatchers(HttpMethod.GET, "/api/v1/**").hasAnyRole("USER", "ADMIN") // define access control
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
    return new UserDetailsServiceImpl(userRepo);
  }
}
