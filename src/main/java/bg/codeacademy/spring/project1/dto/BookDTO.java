package bg.codeacademy.spring.project1.dto;


import bg.codeacademy.spring.project1.model.Comment;

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
  private Integer id;
  private String  author;
  private String  title;
  private Integer yearOfIssue;
  private Integer countComments;
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
