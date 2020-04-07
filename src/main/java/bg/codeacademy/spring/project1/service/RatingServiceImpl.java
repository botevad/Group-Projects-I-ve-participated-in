package bg.codeacademy.spring.project1.service;

import bg.codeacademy.spring.project1.model.Book;
import bg.codeacademy.spring.project1.model.Rating;
import bg.codeacademy.spring.project1.repository.BookRepository;
import bg.codeacademy.spring.project1.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RatingServiceImpl implements RatingService
{
  private final RatingRepository ratingRepository;
  private final UserRepository   userRepository;
  private final BookRepository   bookRepository;

  @Autowired
  public RatingServiceImpl(RatingRepository ratingRepository, UserRepository userRepository, BookRepository bookRepository)
  {
    this.ratingRepository = ratingRepository;
    this.userRepository = userRepository;
    this.bookRepository = bookRepository;
  }

  @Override
  public void addRating(Rating rating)
  {
    this.ratingRepository.save(rating);


  }

  public Optional<Rating> findByBookIdAndUserId(Integer bookId, Integer userId)
  {
    // User user = userRepository.findById(userId).get();
    // Book book = bookRepository.findById(bookId).get();
    return ratingRepository.findByBookIdAndUserId(bookId, userId);
  }

  @Override
  public Double getRating(Book book)
  {
    // System.out.println(ratingRepository.findByBook(book));
    List<Rating> bookRating = ratingRepository.findByBook(book);
    if (bookRating.isEmpty())
    {
      return 0.0;
    }
    double result = (bookRating.stream().mapToDouble(a -> a.getRating()).sum()) / (bookRating.size());
    return result;

  }

  public List<Rating> getAllBookRating(Book book)
  {


    return ratingRepository.findByBook(book);

  }


  public void deleteRating(Rating rating)
  {
    ratingRepository.delete(rating);
  }


}
