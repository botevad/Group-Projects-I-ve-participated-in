package bg.codeacademy.spring.project1.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collection;

@Entity
@Table(name = "roles")
public class Role extends IdEntity
{

  @NotNull(message = "Role name cannot be null")
  private String           name;
  @OneToMany(targetEntity = Role.class)
  @JoinColumn(name = "id")
  private Collection<User> users;

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

}
