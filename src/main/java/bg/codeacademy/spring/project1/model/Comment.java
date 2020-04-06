package bg.codeacademy.spring.project1.model;

import bg.codeacademy.spring.project1.util.DetectHtml;
import bg.codeacademy.spring.project1.validation.NotHtml;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "comments")
public class Comment extends IdEntity
{
  @NotHtml
  private String content;

  @ManyToOne(targetEntity = User.class)
  @JoinColumn(name = "user_id", referencedColumnName = "id")
  private User          user;
  @ManyToOne(targetEntity = Book.class)
  @JoinColumn(name = "book_id", referencedColumnName = "id")
  private Book          book;
  private LocalDateTime date;

  public Comment()
  {
    this.date = LocalDateTime.now();
  }

  public LocalDateTime getDate()
  {
    return date;
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

  public User getUser()
  {
    return user;
  }

  public void setUser(User user)
  {
    this.user = user;
  }

}

