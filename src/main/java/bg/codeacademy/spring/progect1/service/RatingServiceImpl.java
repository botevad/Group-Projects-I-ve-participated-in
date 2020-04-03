package bg.codeacademy.spring.progect1.service;

import bg.codeacademy.spring.progect1.model.Book;
import bg.codeacademy.spring.progect1.model.Rating;
import bg.codeacademy.spring.progect1.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingServiceImpl implements RatingService
{
  @Autowired
  private RatingRepository ratingRepository;

  @Override
  public void addRating(Book book, Rating rating)
  {
    ratingRepository.save(rating);
  }

  @Override
  public void editRating(Book book, Integer rating, Integer id)
  {
    Rating a = ratingRepository.findByBook(book).stream().filter(b -> b.getId() == id).findFirst().get();
    if (a != null) {
      a.setRating(id);
      ratingRepository.save(a);
    }
  }

  @Override
  public Double getRating(Book book)
  {
    return null; // Work in progress
  }

 /* @Override
  public Double getRating(Book book)
  {
    return ratingRepository.findByBook(book).stream().mapToDouble(f -> f.getRating()).average().getAsDouble();
  } */
}
