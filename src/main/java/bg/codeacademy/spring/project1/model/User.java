package bg.codeacademy.spring.project1.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User
{
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;
  private String username;
  private String password;

  public Integer getId()
  {
    return id;
  }

  public User setId(Integer id)
  {
    this.id = id;
    return this;
  }

  public User() {
  }

 @Column(name = "username", unique = true, nullable = false)
  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  @Column(name = "password", nullable = false)
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

}
