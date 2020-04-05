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
  private Integer year;
  private Integer countComments;
  private Double  rating;


  public BookDTO()
  {
  }

  public Integer getId()
  {
    return id;
  }

  public BookDTO setId(Integer id)
  {
    this.id = id;
    return this;
  }

  public String getAuthor()
  {
    return author;
  }

  public BookDTO setAuthor(String author)
  {
    this.author = author;
    return this;
  }

  public String getTitle()
  {
    return title;
  }

  public BookDTO setTitle(String title)
  {
    this.title = title;
    return this;
  }

  public Integer getYear()
  {
    return year;
  }

  public BookDTO setYear(Integer year)
  {
    this.year = year;
    return this;
  }

  public Integer getCountComments()
  {
    return countComments;
  }

  public BookDTO setCountComments(Integer countComments)
  {
    this.countComments = countComments;
    return this;
  }

  public Double getRating()
  {
    return rating;
  }

  public BookDTO setRating(Double rating)
  {
    this.rating = rating;
    return this;
  }
}
