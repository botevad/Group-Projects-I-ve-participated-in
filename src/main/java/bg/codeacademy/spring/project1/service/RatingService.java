package bg.codeacademy.spring.project1.service;

import bg.codeacademy.spring.project1.model.Book;
import bg.codeacademy.spring.project1.model.Rating;

import java.util.List;

public interface RatingService
{
  void addRating(Rating rating);

  List<Rating> getAllBookRating(Book book);

  List<Rating> findByAuthorAndUser(Integer bookId, Integer userId);

  Double getRating(Book book);

  void deleteRating(Rating r);

}
