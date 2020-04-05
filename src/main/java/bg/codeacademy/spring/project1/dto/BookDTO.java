package bg.codeacademy.spring.project1.dto;


import bg.codeacademy.spring.project1.model.Comment;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * DTO Data transfer object is an object that carries data between processes.
 * with getters and setters
 * No use for all the fields of the model object
 */
public class BookDTO
{
  @NotNull(message = "Id cannot be NULL!")
  private Integer id;
  @NotNull(message = "Provide author's name!")
  @Size(min = 1, max = 40, message = "The author's name is too long!")
  private String  author;
  @NotNull(message = "Provide title!")
  @Size(min = 1, max = 60)
  private String  title;
  @NotNull
  private Integer yearOfIssue;
  @NotNull
  private Integer countComments;
  @Range(min = 1, max = 10)
  private Double  rating;

  public BookDTO()
  {
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

  public Integer getCountComments()
  {
    return countComments;
  }

  public void setCountComments(Integer countComments)
  {
    this.countComments = countComments;
  }
}
