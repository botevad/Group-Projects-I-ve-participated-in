package bg.codeacademy.spring.project1.controller;

import bg.codeacademy.spring.project1.model.Book;
import bg.codeacademy.spring.project1.model.Rating;
import bg.codeacademy.spring.project1.model.User;
import bg.codeacademy.spring.project1.service.BookService;
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
@RequestMapping("/ratings")
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
  public void addRating(@RequestParam @NotNull Integer bookID, @RequestBody @Valid Rating rating, @RequestParam @NotNull Integer userId)
  {
    Book b = bookService.getBook(bookID);

    List<Rating> r = new ArrayList<>();
    if (!ratingService.getAllBookRating(b).isEmpty()) {
      r = ratingService.getAllBookRating(b);
    }
    bookService.getBook(bookID);
    Book testBook = bookService.getBook(bookID);
    User u = userService.getUser(userId);
    rating.setBook(testBook);
    rating.setUser(u);

    for (int i = 0; i < r.size(); i++) {
      if (r.get(i).getUser().equals(rating.getUser())) {
        ratingService.deleteRating(r.get(i));
        break;

      }
    }

    rating.setBook(b);
    rating.setUser(u);
    ratingService.addRating(rating);


  }

  @GetMapping("/{id}")
  public Double getRating(@PathVariable @NotNull Integer id)

  {
    return ratingService.getRating(bookService.getBook(id));

  }
}
