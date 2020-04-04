package bg.codeacademy.spring.project1.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.Set;

@Entity
@Table(name = "roles")
public class Role extends IdEntity
{
  @NotNull(message = "Role name cannot be null")
  private String                name;
  @OneToMany(targetEntity = Role.class)
  @JoinColumn(name = "id")
  private Set<User>             users;
  @ManyToMany(targetEntity = Role.class)
  @JoinColumn(name = "id", referencedColumnName = "id")
  private Collection<Privilege> privileges;

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

}
