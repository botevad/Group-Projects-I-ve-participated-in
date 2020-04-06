package bg.codeacademy.spring.project1.controller;

import bg.codeacademy.spring.project1.model.Book;
import bg.codeacademy.spring.project1.model.Rating;
import bg.codeacademy.spring.project1.model.User;
import bg.codeacademy.spring.project1.service.BookService;
import bg.codeacademy.spring.project1.service.RatingService;
import bg.codeacademy.spring.project1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

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
  public ResponseEntity<Void> addRating(@RequestParam @NotNull Integer bookID, @RequestBody @Valid Rating rating, @RequestParam @NotNull Integer userId)
  {
    if (!bookService.getBook(bookID).isPresent()) {
      return ResponseEntity.notFound().build();
    }
    else {
      Book testBook = bookService.getBook(bookID).get();
      List<Rating> r = new ArrayList<>();
      if (!ratingService.getAllBookRating(testBook).isEmpty()) {
        r = ratingService.getAllBookRating(testBook);
      }

      User u = userService.getUser(userId);

      if (ratingService.findByBookAndUser(bookID, userId).isPresent()) {
        ratingService.findByBookAndUser(bookID, userId).get().setRating(rating.getRating());
        return ResponseEntity.ok().build();
      }
      else {
        rating.setBook(testBook);
        rating.setUser(u);
        ratingService.addRating(rating);
        return ResponseEntity.ok().build();
      }
    }


  }
}




