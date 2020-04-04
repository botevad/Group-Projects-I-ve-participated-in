package bg.codeacademy.spring.project1.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "comment")
public class Comment
{
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;
  private String  content;


  @ManyToOne(targetEntity = User.class)
  @JoinColumn(name = "user_id", referencedColumnName = "id")
  private User      user;
  @ManyToOne(targetEntity = Book.class)
  @JoinColumn(name = "book_id", referencedColumnName = "id")
  private Book      book;
  private LocalDate date;

  public LocalDate getDate()
  {
    return date;
  }

  public void setDate()
  {
    this.date = LocalDate.now();
  }


  public Comment()
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

  public String getContent()
  {
    return content;
  }

  public void setContent(String content)
  {
    this.content = content;
  }

  public Book getBook()
  {
    return book;
  }

  public void setBook(Book book)
  {
    this.book = book;
  }

}

