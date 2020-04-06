package bg.codeacademy.spring.project1.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "books", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"title" ,"author"})
})

public class Book extends IdEntity
{
  @Column(nullable = false)
  private String  title;
  @Column(nullable = false)
  private String  author;
  @Column(nullable = false)
  private Integer year;

  public Book()
  {
  }

  public String getTitle()
  {
    return title;
  }

  public void setTitle(String title)
  {
    this.title = title;
  }

  public String getAuthor()
  {
    return author;
  }

  public void setAuthor(String author)
  {
    this.author = author;
  }

  public Integer getYear()
  {
    return year;
  }

  public void setYear(Integer year)
  {
    this.year = year;
  }
}
