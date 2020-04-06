package bg.codeacademy.spring.project1.service;

import bg.codeacademy.spring.project1.model.Book;
import bg.codeacademy.spring.project1.model.Rating;
import bg.codeacademy.spring.project1.model.User;
import bg.codeacademy.spring.project1.repository.BookRepository;
import bg.codeacademy.spring.project1.repository.RatingRepository;
import bg.codeacademy.spring.project1.repository.UserRepository;
import org.testng.annotations.DataProvider;

import static org.mockito.Mockito.mock;

public class RatingServiceTest {

    RatingRepository ratingRepositoryMock = mock(RatingRepository.class);
    UserRepository userRepositoryMock = mock(UserRepository.class);
    BookRepository bookRepositoryMock = mock(BookRepository.class);

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
                        {rating}
                };
    }
}
