package bg.codeacademy.spring.progect1.model;
import bg.codeacademy.spring.project1.model.Book;

import javax.persistence.*;

@Entity
@Table(name = "ratings")
public class Rating
{
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;
  private Integer rating;
  @ManyToOne(targetEntity = Book.class)
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
