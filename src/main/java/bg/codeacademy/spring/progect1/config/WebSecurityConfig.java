package bg.codeacademy.spring.progect1.config;

import bg.codeacademy.spring.progect1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

@Configuration
@EnableWebSecurity
/**
 * Security configuration
 */
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /*http.authorizeRequests() //for future settings
                .antMatchers("/login").permitAll()
                .antMatchers("/test/**").hasRole("USER")
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .permitAll();*/
        http.authorizeRequests()
                .antMatchers(HttpMethod.GET, "/test/hello").hasRole("FRIEND") // define access control
                .antMatchers(HttpMethod.GET, "/test/book").hasRole("ADMIN")
                .and()
                .formLogin().and().httpBasic(); // use the default login and logout pages, and http basic authentication
    }

    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {

            @Autowired
            private UserRepository userRepo;

            @Override
            public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
                List<bg.codeacademy.spring.progect1.model.User> users = userRepo.findAll();
                if (users.isEmpty()) {
                    // first start, create default admin user
                    bg.codeacademy.spring.progect1.model.User admin = new bg.codeacademy.spring.progect1.model.User();
                    admin.setUsername("admin");
                    admin.setPassword("123456");
                    userRepo.saveAndFlush(admin);
                    users.add(admin);
                }
                for (bg.codeacademy.spring.progect1.model.User user : users) {
                    if (user.getUsername().equals(userName)) {
                        return User.withDefaultPasswordEncoder()
                                .username(userName)
                                .password(user.getPassword())
                                .roles("ADMIN", "FRIEND") // TODO add roles in the user bean
                                .build();
                    }
                }
                return null;
            }
        };
    }

}
