package bg.codeacademy.spring.progect1.model;


import javax.persistence.*;

@Entity
public class Book
{
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;
  private String  title;
  private String  author;
  private int     year;
  private double  price;
  private int     availableCopies;


  public Integer getId()
  {
    return id;
  }

  public Book setId(Integer id)
  {
    this.id = id;
    return this;
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
    return;
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

  public int getAvailableCopies()
  {
    return availableCopies;
  }

  public void setAvailableCopies(int availableCopies)
  {
    this.availableCopies = availableCopies;
  }
}
