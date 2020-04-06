package bg.codeacademy.spring.project1.dto;

import bg.codeacademy.spring.project1.model.Book;
import bg.codeacademy.spring.project1.model.User;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.time.LocalDateTime;

public class CommentDTO
{
  private String        content;
  private LocalDateTime time;
  private String        userName;


  public CommentDTO()
  {
  }

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

  public String getUserName()
  {
    return userName;
  }

  public CommentDTO setUserName(String userName)
  {
    this.userName = userName;
    return this;
  }




}
