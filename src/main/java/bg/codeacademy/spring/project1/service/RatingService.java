package bg.codeacademy.spring.project1.service;

import bg.codeacademy.spring.project1.model.Book;
import bg.codeacademy.spring.project1.model.Rating;

import java.util.List;

public interface RatingService
{
  void addRating(Rating rating);

  // void editRating(Book book, Integer rating, Integer id);

  List<Rating> getAllBookRating(Book book);

  List<Rating> findByAuthorAndUser(Integer bookId, Integer userId);

  void deleteRating(Rating rating);

  Double getRating(Book book);
}
