package bg.codeacademy.spring.project1.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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

  public String getAuthorName()
  {
    return authorName;
  }

  public CommentDTO setAuthorName(String authorName)
  {
    this.authorName = authorName;
    return this;
  }

  @NotNull(message = "The content of the comments cannot be NULL!")
  @Size(min = 2, max = 256, message = "Content of the comments should be between 2 and 256 characters!")
  private String        content;
  private LocalDateTime time;
  @NotNull()
  private String        authorName;

  public CommentDTO()
  {
  }

}
