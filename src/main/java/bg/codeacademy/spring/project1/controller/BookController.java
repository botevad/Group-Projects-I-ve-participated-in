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
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api/v1/books")
public class BookController
{

  private final BookService    bookService;
  private final RatingService  ratingService;
  private final CommentService commentService;
  private final UserService    userService;

  @Autowired
  public BookController(BookService bookService,
                        RatingService ratingService,
                        CommentService commentService,
                        UserService userService)
  {
    this.bookService = bookService;
    this.ratingService = ratingService;
    this.commentService = commentService;
    this.userService = userService;
  }


  @GetMapping("/{id}")
  public ResponseEntity<BookDTOWithComments> getBook(@PathVariable Integer id)
  {
    if (!bookService.getBook(id).isPresent()) {
      return ResponseEntity.notFound().build();
    }
    else {
      Book modelBook = bookService.getBook(id).get();
      BookDTOWithComments bookForClient = new BookDTOWithComments();
      List<CommentDTO> comments = new ArrayList<>();
      List<Comment> c = commentService.getAllComments(modelBook);
      for (Comment comment : c) {
        CommentDTO commentDTO = new CommentDTO()
            .setAuthorName(comment.getUser().getUsername())
            .setContent(comment.getContent())
            .setTime(comment.getDate());
        comments.add(commentDTO);
      }
      bookForClient.setId(modelBook.getId())
          .setYear(modelBook.getYear())
          .setAuthor(modelBook.getAuthor())
          .setTitle(modelBook.getTitle())
          .setRating(ratingService.getRating(modelBook));
      bookForClient.setCommentList(comments);

      return ResponseEntity.ok(bookForClient);
    }
  }


  @PostMapping()
  public ResponseEntity<Book> addBook(@RequestBody Book book)  //adding a object Book to the repo
  {
    book.setId(null);

    return ResponseEntity.ok(bookService.addBook(book));
  }


  @DeleteMapping("/{id}")
  public ResponseEntity<Void> removeBook(@PathVariable Integer id)
  {
    if (!bookService.getBook(id).isPresent()) {
      return ResponseEntity.badRequest().build();
    }
    else {
      bookService.removeBook(id);
      return ResponseEntity.ok().build();
    }
  }

  @GetMapping()
  public ResponseEntity<List<BookDTO>> findAllBooks(
      @RequestParam(required = false, defaultValue = "*") String title,
      @RequestParam(required = false, defaultValue = "*") String author)

  {

    List<BookDTO> books = new ArrayList<>();

    if (!bookService.findBookByCriteria(title, author).isPresent()) {
      return ResponseEntity.notFound().build();
    }
    else {
      List<Book> originBooks = bookService.findBookByCriteria(title, author).get();

      for (int i = 0; i < originBooks.size(); i++) {
        BookDTO bookDto = new BookDTO()
            .setId(originBooks.get(i).getId())
            .setAuthor(originBooks.get(i).getAuthor())
            .setTitle(originBooks.get(i).getTitle())
            .setYear(originBooks.get(i).getYear())
            .setRating(ratingService.getRating(originBooks.get(i)))
            .setCountComments(commentService.getAllComments(originBooks.get(i)).size());

        books.add(bookDto);
      }
      return ResponseEntity.ok(books);
    }

  }


  @PutMapping("/{id}")
  public ResponseEntity<Book> editBook(@PathVariable Integer id, @RequestBody Book book)
  {
    if (!bookService.getBook(id).isPresent()) {
      return ResponseEntity.badRequest().build();
    }
    else {
      Book b = bookService.getBook(id).get();
      b.setAuthor(book.getAuthor());
      b.setTitle(book.getTitle());
      b.setYear(book.getYear());
      bookService.addBook(b);
      return ResponseEntity.ok(b);
    }

  }

}


