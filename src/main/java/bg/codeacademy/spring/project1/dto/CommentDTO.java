package bg.codeacademy.spring.project1.dto;

import bg.codeacademy.spring.project1.model.Book;
import bg.codeacademy.spring.project1.model.User;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.time.LocalDateTime;

public class CommentDTO
{
  public String getContent()
  {
    return content;
  }

  public CommentDTO setContent(String content)
  {
    this.content = content;
    return this;
  }

  public LocalDateTime getTime()
  {
    return time;
  }

  public CommentDTO setTime(LocalDateTime time)
  {
    this.time = time;
    return this;
  }

  public String getUsername() {
    return username;
  }

  public CommentDTO setUsername(String username) {
    this.username = username;
    return this;
  }

  private String        content;
  private LocalDateTime time;
  private String        username;

  public CommentDTO()
  {
  }

}
