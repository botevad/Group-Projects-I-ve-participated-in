package bg.codeacademy.spring.project1.service;

import bg.codeacademy.spring.project1.model.Book;
import bg.codeacademy.spring.project1.model.Rating;
import bg.codeacademy.spring.project1.model.User;
import bg.codeacademy.spring.project1.repository.RatingRepository;
import bg.codeacademy.spring.project1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RatingServiceImpl implements RatingService
{
  private final RatingRepository ratingRepository;
  private final UserRepository   userRepository;

  @Autowired
  public RatingServiceImpl(RatingRepository ratingRepository, UserRepository userRepository)
  {
    this.ratingRepository = ratingRepository;
    this.userRepository = userRepository;
  }

  @Override
  public void addRating(Rating rating)
  {
    this.ratingRepository.save(rating);

  }

  public Optional<Rating> findByBookAndUser(Integer bookId, Integer userId)
  {
    return ratingRepository.findRatingByBook_IdAndUser_Id(bookId, userId);
  }

  @Override
  public Double getRating(Book book)
  {
    double az = ratingRepository.findByBook(book).stream().mapToDouble(a -> a.getRating()).sum();
    double result = az / ratingRepository.findByBook(book).size();
    return result;
  }

  public List<Rating> getAllBookRating(Book book)
  {

    return ratingRepository.findByBook(book);

  }


  public void deleteRating(Rating r)
  {
    ratingRepository.delete(r);
  }


}
