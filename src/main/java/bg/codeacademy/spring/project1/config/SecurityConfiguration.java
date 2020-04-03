package bg.codeacademy.spring.project1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

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
        .antMatchers("/index.html").permitAll()
        .antMatchers("/profile/**").authenticated()
        .antMatchers("/admin/**").hasRole("ADMIN")
        .antMatchers("/books/**").hasAnyRole("ADMIN", "USER")
        .antMatchers("/api/public/users").hasRole("ADMIN")
        .and()
        .httpBasic();


    http.csrf().disable();
    http.headers().frameOptions().disable();
  }


  @Bean
  PasswordEncoder passwordEncoder()
  {
    return new BCryptPasswordEncoder();
  }
}
