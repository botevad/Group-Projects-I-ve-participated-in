package bg.codeacademy.spring.project1.controller;

import bg.codeacademy.spring.project1.dto.BookDTO;
import bg.codeacademy.spring.project1.dto.BookDTOWithComments;
import bg.codeacademy.spring.project1.dto.CommentDTO;
import bg.codeacademy.spring.project1.model.Book;
import bg.codeacademy.spring.project1.model.Comment;
import bg.codeacademy.spring.project1.service.BookService;
import bg.codeacademy.spring.project1.service.CommentService;
import bg.codeacademy.spring.project1.service.RatingService;
import bg.codeacademy.spring.project1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;


@RestController
@Validated
@RequestMapping("/books")
public class BookController
{

  private final BookService    bookService;
  private final RatingService  ratingService;
  private final CommentService commentService;
  private final UserService    userService;

  @Autowired
  public BookController(BookService bookService, RatingService ratingService, CommentService commentService, UserService userService)
  {
    this.bookService = bookService;
    this.ratingService = ratingService;
    this.commentService = commentService;
    this.userService = userService;
  }


  @GetMapping("/{id}")
  public BookDTOWithComments getBook(@PathVariable @NotNull Integer id)
  {
    Book modelBook = bookService.getBook(id);
    BookDTOWithComments bookForClient = new BookDTOWithComments();
    List<CommentDTO> comments = new ArrayList<>();
    CommentDTO commentDTO = new CommentDTO();
    List<Comment> c = commentService.getAllComments(modelBook.getId());
    for (int i = 0; i < c.size(); i++) {
      commentDTO.setAuthorName(c.get(i).getUser().getUsername());
      commentDTO.setContent(c.get(i).getContent());
      commentDTO.setTime(c.get(i).getDate());
      comments.add(commentDTO);
    }
    bookForClient.setId(modelBook.getId());
    bookForClient.setYearOfIssue(modelBook.getYear());
    bookForClient.setAuthor(modelBook.getAuthor());
    bookForClient.setTitle(modelBook.getTitle());
    bookForClient.setRating(ratingService.getRating(modelBook));
    bookForClient.setCommentList(comments);

    return bookForClient;
  }


  @PostMapping()
  public Book addBook(@RequestBody @Valid Book book)  //adding a object Book to the repo
  {

    return bookService.addBook(book);

  }


  @DeleteMapping("/{id}")
  public void removeBook(@PathVariable @NotNull Integer id)
  {
    bookService.removeBook(id);
  }

  @GetMapping()
  public List<BookDTO> findAllBooks()
  {
    List<BookDTO> books = new ArrayList<>();

    List<Book> originBooks = bookService.findAllBooks();


    for (int i = 0; i < originBooks.size(); i++) {
      BookDTO bookDto = new BookDTO();
      bookDto.setId(originBooks.get(i).getId());
      bookDto.setAuthor(originBooks.get(i).getAuthor());
      bookDto.setTitle(originBooks.get(i).getTitle());
      bookDto.setYearOfIssue(originBooks.get(i).getYear());
      bookDto.setRating(ratingService.getRating(originBooks.get(i)));
//NULL PROBLEM !!!!
      //bookDto.setCountComments(commentService.getAllComments(originBooks.get(i).getId()).size());


      books.add(bookDto);


    }


    return books;
  }

  @PutMapping("/edit/{id}")
  public Book editBook(@PathVariable @NotNull Integer id, @RequestBody @Valid Book book)
  {
    Book b = bookService.getBook(id);

    b.setAuthor(book.getAuthor());
    b.setTitle(book.getTitle());
    b.setYear(book.getYear());
    bookService.addBook(b);
    return b;
  }


  @GetMapping("/get-by")
  public List<Book> findBookByCriteria(@Valid @RequestParam(required = false, defaultValue = "*") String title,
                                       @Valid @RequestParam(required = false, defaultValue = "*") String author,
                                       @Valid @RequestParam(required = false, defaultValue = "-1") Integer year)
  {


    return bookService.findBookByCriteria(title, author, year);
  }


}


