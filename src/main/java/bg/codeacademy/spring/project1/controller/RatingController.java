package bg.codeacademy.spring.project1.controller;

import bg.codeacademy.spring.project1.model.Book;
import bg.codeacademy.spring.project1.model.Rating;
import bg.codeacademy.spring.project1.service.BookService;
import bg.codeacademy.spring.project1.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/ratings")
public class RatingController
{
  private final RatingService ratingService;
  private final BookService   bookService;
  private final UserService   userService;

  @Autowired
  public RatingController(RatingService ratingService, BookService bookService, UserService userService)
  {
    this.ratingService = ratingService;
    this.bookService = bookService;
    this.userService = userService;
  }

  @PostMapping()
  public ResponseEntity<Void> addRating(@RequestParam Integer bookId, @RequestBody Rating rating, @RequestParam Integer userId)
  {
    Book testBook;
    if (!bookService.getBook(bookId).isPresent() && userService.getUser(userId).isPresent()) {
      return ResponseEntity.notFound().build();
    }
    else {
      testBook = bookService.getBook(bookId).get();
      User u = userService.getUser(userId).get();
      if (ratingService.findByBookIdAndUserId(bookId, userId).isPresent()) {
        ratingService.findByBookIdAndUserId(bookId, userId).get().setRating(rating.getRating());
        ratingService.addRating(ratingService.findByBookIdAndUserId(bookId, userId).get());
        return ResponseEntity.ok().build();
      }
      else {
        rating.setBook(testBook);
        rating.setUser(u);
        rating.setRating(rating.getRating());

        ratingService.addRating(rating);
      }

      return ResponseEntity.ok().build();
    }
  }
}








