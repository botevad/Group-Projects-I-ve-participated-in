package bg.codeacademy.spring.project1.model;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "ratings")
public class Rating
{
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  @Min(value = 1, message = "Rating should not be less than 1")
  @Max(value = 10, message = "Rating should not be greater than 10")
  private Integer rating;
  
  @ManyToOne(targetEntity = Book.class)
  @NotNull
  private Book book;
  
  public Rating()
  {
  }

  public Integer getId()
  {
    return id;
  }

  public void setId(Integer id)
  {
    this.id = id;
  }

  public Integer getRating()
  {
    return rating;
  }

  public void setRating(Integer rating)
  {
    this.rating = rating;
  }
}
