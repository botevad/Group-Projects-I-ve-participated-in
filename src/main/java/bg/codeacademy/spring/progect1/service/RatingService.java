package bg.codeacademy.spring.progect1.service;

import bg.codeacademy.spring.progect1.model.Book;
import bg.codeacademy.spring.progect1.model.Rating;

public interface RatingService
{
  void addRating(Book book, Rating rating);

  void editRating(Book book, Integer rating, Integer id);

  Double getRating(Book book);
}
