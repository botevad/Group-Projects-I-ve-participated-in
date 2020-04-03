package bg.codeacademy.spring.project1.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collection;

@Entity
@Table(name = "privileges")
public class Privilege
{
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", updatable = false, nullable = false)
  private Long   id;
  @NotNull(message = "Privilege name cannot be null")
  private String name;

  @ManyToMany(targetEntity = Privilege.class)
  private Collection<Role> roles;
  @JoinColumn(name = "id", referencedColumnName = "id")

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }
}
