package bg.codeacademy.spring.project1.model;

import javax.persistence.*;

@Entity
@Table(name = "comment")
public class Comment
{
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  private String content;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "author_id", referencedColumnName = "id")
  private User author;
  @ManyToOne(targetEntity = Book.class)
  private Book book;
  @ManyToOne(targetEntity = User.class)
  private User user;
  public Comment()
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

  public String getContent()
  {
    return content;
  }

  public void setContent(String content)
  {
    this.content = content;
  }

  public User getAuthor()
  {
    return author;
  }

  public void setAuthor(User author)
  {
    this.author = author;
  }
}

