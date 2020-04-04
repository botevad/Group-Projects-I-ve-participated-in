package bg.codeacademy.spring.project1.model;

import javax.persistence.*;

@Entity
@Table(name = "books")
public class Book
{
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer         id;
  @Column(name = "title", nullable = false)
  private String      title;
  @Column(name = "author", nullable = false)
  private String      author;
  @Column(name = "year", nullable = false)
  private Integer       year;

  public Book()
  {
  }

  public Integer getId()
  {
    return id;
  }

  public void setId(Integer id)
  {
    this.id = id;
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

  public int getYear()
  {
    return year;
  }

  public void setYear(int year)
  {
    this.year = year;
  }

}
