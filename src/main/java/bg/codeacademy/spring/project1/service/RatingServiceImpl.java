package bg.codeacademy.spring.project1.service;

import bg.codeacademy.spring.project1.model.Book;
import bg.codeacademy.spring.project1.model.Rating;
import bg.codeacademy.spring.project1.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService
{
  @Autowired
  private RatingRepository ratingRepository;


  @Override
  public void addRating(Rating rating)
  {
    this.ratingRepository.save(rating);
  }

  @Override
  public List<Rating> getAllBookRating(Book book)
  {
    return ratingRepository.findByBook(book);
  }

  @Override
  public List<Rating> findByAuthorAndUser(Integer bookId, Integer userId)
  {
    return ratingRepository.findRatingByBook_IdAndUser_Id(bookId, userId);
  }

  @Override
  public void deleteRating(Rating rating)
  {
    ratingRepository.delete(rating);
  }

  @Override
  public Double getRating(Book book)
  {
    double rating = (ratingRepository.findByBook(book).stream().mapToDouble(a -> a.getRating()).sum()) /
        (ratingRepository.findByBook(book).size());
    return rating;
  }
}
