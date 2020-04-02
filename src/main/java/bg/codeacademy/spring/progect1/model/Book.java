package bg.codeacademy.spring.progect1.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "books")
public class Book
{
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int         id;
  @Column(name = "title", nullable = false)
  private String      title;
  @Column(name = "author", nullable = false)
  private String      author;
  @Column(name = "year", nullable = false)
  private int         year;
  @Column(name = "price", nullable = false)
  private double      price;

  public Book()
  {
  }

  public int getId()
  {
    return id;
  }

  public void setId(int id)
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

  public double getPrice()
  {
    return price;
  }

  public void setPrice(double price)
  {
    this.price = price;
  }

}
