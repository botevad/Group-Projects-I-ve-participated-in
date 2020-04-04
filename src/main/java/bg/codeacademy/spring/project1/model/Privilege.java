package bg.codeacademy.spring.project1.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "privileges")
public class Privilege extends IdEntity
{
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Double id;
  @Column(nullable = false)
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
