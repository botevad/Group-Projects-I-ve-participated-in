package bg.codeacademy.spring.project1.model;

import bg.codeacademy.spring.project1.dto.UserDTO;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "comments")
public class Comment extends IdEntity
{
  private String content;

  @OneToOne (targetEntity = User.class)
  @JoinColumn(name = "user_id", referencedColumnName = "id")
  private UserDTO user;
  @OneToOne(targetEntity = Book.class)
  @JoinColumn(name = "book_id", referencedColumnName = "id")
  private Book    book;
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

  public UserDTO getUser()
  {
    return user;
  }

  public void setUser(UserDTO user)
  {
    this.user = user;
  }
}

