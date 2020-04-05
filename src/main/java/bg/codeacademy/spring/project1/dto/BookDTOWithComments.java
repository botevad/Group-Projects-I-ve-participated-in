package bg.codeacademy.spring.project1.dto;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BookDTOWithComments
{
  @NotNull(message = "Id cannot be NULL!")
  private Integer          id;
  @NotNull(message = "Provide author's name!")
  @Size(min = 1, max = 40, message = "The author's name is too long!")
  private String           author;
  @NotNull(message = "Provide title!")
  @Size(min = 1, max = 60)
  private String           title;
  @NotNull
  private Integer          yearOfIssue;
  private List<CommentDTO> commentList = new ArrayList<>();
  @Range(min = 1, max = 10)
  private Double           rating;

  public BookDTOWithComments()
  {
  }

  public List<CommentDTO> getCommentList()
  {
    Comparator<CommentDTO> byTime = Comparator.comparing(CommentDTO::getTime);

    commentList.sort(byTime);
    return Collections.unmodifiableList(commentList);
  }

  public void setCommentList(List<CommentDTO> commentList)
  {
    this.commentList = commentList;
  }

  public Double getRating()
  {
    return rating;
  }

  public void setRating(Double rating)
  {
    this.rating = rating;
  }

  public Integer getId()
  {
    return id;
  }

  public void setId(Integer id)
  {
    this.id = id;
  }

  public String getAuthor()
  {
    return author;
  }

  public void setAuthor(String author)
  {
    this.author = author;
  }

  public String getTitle()
  {
    return title;
  }

  public void setTitle(String title)
  {
    this.title = title;
  }

  public Integer getYearOfIssue()
  {
    return yearOfIssue;
  }

  public void setYearOfIssue(Integer yearOfIssue)
  {
    this.yearOfIssue = yearOfIssue;
  }

}


