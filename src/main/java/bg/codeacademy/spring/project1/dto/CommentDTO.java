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
  private String        authorName;

  public CommentDTO()
  {
  }

  public String getContent()
  {
    return content;
  }

  public void setContent(String content)
  {
    this.content = content;
  }

  public LocalDateTime getTime()
  {
    return time;
  }

  public void setTime(LocalDateTime time)
  {
    this.time = time;
  }

  public String getAuthorName()
  {
    return authorName;
  }

  public void setAuthorName(String authorName)
  {
    this.authorName = authorName;
  }
}
