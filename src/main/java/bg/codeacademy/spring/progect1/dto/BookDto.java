package bg.codeacademy.spring.progect1.dto;

public class BookDto
{
  private Integer id;
  private String  title;
  private String  author;
  private Integer year;

  public Integer getId()
  {
    return id;
  }

  public BookDto setId(Integer id)
  {
    this.id = id;
    return this;
  }

  public String getTitle()
  {
    return title;
  }

  public BookDto setTitle(String title)
  {
    this.title = title;
    return this;
  }

  public String getAuthor()
  {
    return author;
  }

  public BookDto setAuthor(String author)
  {
    this.author = author;
    return this;
  }

  public Integer getYear()
  {
    return year;
  }

  public BookDto setYear(Integer year)
  {
    this.year = year;
    return this;
  }
}
