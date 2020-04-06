package bg.codeacademy.spring.project1.service;

import bg.codeacademy.spring.project1.model.Book;
import bg.codeacademy.spring.project1.model.Rating;
import bg.codeacademy.spring.project1.model.User;
import bg.codeacademy.spring.project1.repository.BookRepository;
import bg.codeacademy.spring.project1.repository.RatingRepository;
import bg.codeacademy.spring.project1.repository.UserRepository;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import javax.xml.crypto.Data;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;

public class RatingServiceTest {

    RatingRepository ratingRepositoryMock = mock(RatingRepository.class);
    UserRepository userRepositoryMock = mock(UserRepository.class);
    BookRepository bookRepositoryMock = mock(BookRepository.class);

    RatingService ratingService = new RatingServiceImpl(ratingRepositoryMock, userRepositoryMock, bookRepositoryMock);

    @DataProvider(name = "rating-data")
    public Object[][] dataProviderMethod()
    {
        Rating rating = new Rating();

        User user = new User();
        user.setId(99);
        user.setUsername("pesho");
        user.setPassword("123");

        Book book = new Book();
        book.setId(10);
        book.setTitle("az");
        book.setAuthor("skaa");
        book.setYear(1900);

        rating.setRating(7);
        rating.setBook(book);
        rating.setUser(user);
        rating.setId(71);

        return new Object[][]
                {
                        {rating, book, user}
                };
    }

   @Test(dataProvider = "rating-data")
    public void it_should_add_rating(Rating rating)
    {
        ratingService.addRating(rating);

        Mockito.verify(ratingRepositoryMock, times(1)).save(rating);
    }

    @Test(dataProvider = "rating-data")
    public void should_get_rating(Rating rating, Book book, User user)
    {
        double result = ratingService.getRating(book);

        Mockito.verify(ratingRepositoryMock, times(1)).findByBook(book);
        Assert.assertEquals(result, 0.0);
    }

    @Test(dataProvider = "rating-data")
    public void should_delete_rating(Rating rating, Book book, User user)
    {
        ratingService.deleteRating(rating);

        Mockito.verify(ratingRepositoryMock, times(1)).delete(rating);
    }

    @Test(dataProvider = "rating-data")
    public void should_get_all_book_ratings(Rating rating, Book book, User user)
    {
        List<Rating> ratingList = ratingService.getAllBookRating(book);

        Mockito.verify(ratingRepositoryMock, times(1)).findByBook(book);
    }

    @Test(dataProvider = "rating-data")
    public void should_get_rating_by_ids(Rating rating, Book book, User user)
    {
        Optional<Rating> optionalRating = ratingService.findByBookIdAndUserId(book.getId(), user.getId());

        Mockito.verify(ratingRepositoryMock, times(1)).
                findByBookIdAndUserId(book.getId(), user.getId());
    }
}
