package bg.codeacademy.spring.project1.dto;

import javax.validation.constraints.*;
import java.time.LocalDateTime;

public class CommentDTO
{
  @NotNull(message = "The content of the comments cannot be NULL!")
  @Size(min = 2, max = 256, message = "Content of the comments should be between 2 and 256 characters!")
  private String        content;
  private LocalDateTime time;
  @NotNull()
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
