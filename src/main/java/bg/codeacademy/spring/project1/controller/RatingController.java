package bg.codeacademy.spring.project1.controller;

import bg.codeacademy.spring.project1.model.Book;
import bg.codeacademy.spring.project1.model.Rating;
import bg.codeacademy.spring.project1.model.User;
import bg.codeacademy.spring.project1.repository.BookRepository;
import bg.codeacademy.spring.project1.service.BookService;
import bg.codeacademy.spring.project1.service.RatingService;
import bg.codeacademy.spring.project1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController
{
  @Autowired
  private RatingService ratingService;
  @Autowired
  private BookService   bookService;
  @Autowired
  private UserService   userService;

  @PostMapping()
  public void addRating(@RequestParam Integer bookID, @RequestBody Rating rating, @RequestParam Integer userId)
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
  public Double getRating(@PathVariable Integer id)

  {
    return ratingService.getRating(bookService.getBook(id));

  }
}
