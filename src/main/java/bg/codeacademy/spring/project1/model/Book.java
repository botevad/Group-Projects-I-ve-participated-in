package bg.codeacademy.spring.project1.model;


import javax.persistence.*;
import java.lang.annotation.Retention;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "books", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"title", "author"})
})

public class Book extends IdEntity
{
  @Column(name = "title", nullable = false)
  private String  title;
  @Column(name = "author", nullable = false)
  private String  author;
  @Column(name = "year", nullable = false)
  private Integer year;

  public Book()
  {
  }

  public String getTitle()
  {
    return title;
  }

  public Book setTitle(String title)
  {
    this.title = title;
    return this;
  }

  public String getAuthor()
  {
    return author;
  }

  public Book setAuthor(String author)
  {
    this.author = author;
    return this;
  }

  public Integer getYear()
  {
    return year;
  }

  public Book setYear(Integer year)
  {
    this.year = year;
    return this;
  }
}
