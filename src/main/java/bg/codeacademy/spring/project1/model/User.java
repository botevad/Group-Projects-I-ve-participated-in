package bg.codeacademy.spring.project1.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User extends IdEntity
{
  @Column(name = "username", unique = true, nullable = false)
  private String  username;
  @Column(name = "password", nullable = false)
  private String  password;
  @OneToOne
  private Role role;
  private boolean isEnabled; //isEnabled will be false by default

  /**
   * We need a default constructor, otherwise we get
   * org.springframework.orm.jpa.JpaSystemException: No default constructor for entity:  : bg.codeacademy.spring.project1.model.User
   */
  public User()
  {
  }

  //user created by Admin can have a directly approved state
  public User(boolean isEnabled)
  {
    this.isEnabled = isEnabled;
  }

  public String getUsername()
  {
    return username;
  }

  public void setUsername(String username)
  {
    this.username = username;
  }

  public String getPassword()
  {
    return password;
  }

  public void setPassword(String password)
  {
    this.password = password;
  }
}
