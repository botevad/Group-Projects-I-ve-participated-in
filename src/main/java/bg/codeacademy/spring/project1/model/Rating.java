package bg.codeacademy.spring.project1.model;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;

@Entity
@Table(name = "ratings")
public class Rating
{
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;
  @Value("${some.key:0}")
  private Integer rating;
  @ManyToOne(targetEntity = Book.class)
  @JoinColumn(name = "user_id", referencedColumnName = "id")
  private Book book;
  @OneToOne(targetEntity = User.class)
  @JoinColumn(name = "used_id", referencedColumnName = "user")
  private User user;

  public Book getBook()
  {
    return book;
  }

  public Rating setBook(Book book)
  {
    this.book = book;
    return this;
  }

  public User getUser()
  {
    return user;
  }

  public Rating setUser(User user)
  {
    this.user = user;
    return this;
  }

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
