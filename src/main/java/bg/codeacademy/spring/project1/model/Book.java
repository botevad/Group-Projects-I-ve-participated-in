package bg.codeacademy.spring.project1.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "books", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"title" ,"author"})
})

public class Book extends IdEntity
{
  @Column(name = "title", nullable = false)
  @NotEmpty(message = "Provide title!")
  @Size(min = 2, max = 60, message = "Title between 1 and 60 characters")
  private String  title;
  @Column(name = "author", nullable = false)
  @NotEmpty(message = "Provide author's name!")
  @Size(min = 2, max = 40, message = "The author's name - between 1 and 40 characters!")
  private String  author;
  @Column(name = "year", nullable = false)
  @NotNull(message = "Provide year!")
  @Positive(message = "Provide positive year!")
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
