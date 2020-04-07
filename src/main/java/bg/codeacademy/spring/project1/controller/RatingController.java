package bg.codeacademy.spring.project1.controller;

import bg.codeacademy.spring.project1.model.Book;
import bg.codeacademy.spring.project1.model.Rating;
import bg.codeacademy.spring.project1.model.User;
import bg.codeacademy.spring.project1.service.BookService;
import bg.codeacademy.spring.project1.service.RatingService;
import bg.codeacademy.spring.project1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
  public ResponseEntity<Void> addRating(@RequestParam Integer bookId, @RequestBody @Valid Rating rating, Principal principal)
  {
    Book testBook;
    if (!bookService.getBook(bookId).isPresent() && userService.getUser(principal.getName()) == null) {
      return ResponseEntity.notFound().build();
    }
    else {
      testBook = bookService.getBook(bookId).get();
      User u = userService.getUser(principal.getName());
      Optional<Rating> r = ratingService.findByBookIdAndUserId(bookId, u.getId());
      if (r.isPresent()) {
        r.get().setRating(rating.getRating());
        ratingService.addRating(ratingService.findByBookIdAndUserId(bookId, u.getId()).get());
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








