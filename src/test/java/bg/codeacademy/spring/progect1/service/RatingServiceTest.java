package bg.codeacademy.spring.progect1.service;

import bg.codeacademy.spring.project1.enums.Role;
import bg.codeacademy.spring.project1.model.Book;
import bg.codeacademy.spring.project1.model.Rating;
import bg.codeacademy.spring.project1.model.User;
import bg.codeacademy.spring.project1.repository.BookRepository;
import bg.codeacademy.spring.project1.repository.CommentRepository;
import bg.codeacademy.spring.project1.repository.RatingRepository;
import bg.codeacademy.spring.project1.repository.UserRepository;
import bg.codeacademy.spring.project1.service.RatingService;
import bg.codeacademy.spring.project1.service.RatingServiceImpl;
import org.junit.Assert;
import org.mockito.Mockito;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Optional;

import static java.lang.Double.NaN;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;

public class RatingServiceTest {

    RatingRepository ratingRepositoryMock = mock(RatingRepository.class);
    BookRepository bookRepositoryMock = mock(BookRepository.class);
    UserRepository userRepositoryMock = mock(UserRepository.class);

    RatingService ratingService = new RatingServiceImpl(ratingRepositoryMock, userRepositoryMock, bookRepositoryMock);

    @DataProvider(name = "rating-data")
    public Object[][] dataProviderMethod() {
        Book book1 = new Book();
        book1.setId(19);
        book1.setYear(1900);
        book1.setAuthor("Ivan");
        book1.setTitle("knijka");

        User user1 = new User();
        user1.setPassword("123");
        user1.setUsername("usercheto");
        user1.setId(21);
        user1.setRole(Role.USER);

        Rating rating1 = new Rating();
        rating1.setId(9);
        rating1.setUser(user1);
        rating1.setBook(book1);
        rating1.setRating(5);

        Book book2 = new Book();
        book2.setId(219);
        book2.setYear(2900);
        book2.setAuthor("goshso");
        book2.setTitle("zaglavie");

        User user2 = new User();
        user2.setPassword("parola");
        user2.setUsername("hater");
        user2.setId(31);
        user2.setRole(Role.ADMIN);
        user2.isEnabled();

        Rating rating2 = new Rating();
        rating2.setId(29);
        rating2.setUser(user2);
        rating2.setBook(book2);
        rating2.setRating(7);

        Book book3 = new Book();
        book3.setId(60);
        book3.setYear(2020);
        book3.setAuthor("rado");
        book3.setTitle("book");

        User user3 = new User();
        user3.setPassword("11223");
        user3.setUsername("user2");
        user3.setId(321);
        user3.setRole(Role.USER);

        Rating rating3 = new Rating();
        rating3.setId(10);
        rating3.setUser(user3);
        rating3.setBook(book3);
        rating3.setRating(10);


        return new Object[][]
                {
                        {rating1, book1, user1}, {rating2, book2, user2}, {rating3, book3, user3}
                };
    }

    @Test(dataProvider = "rating-data")
    public void it_should_add_rating(Rating rating, Book book, User user) {
        ratingService.addRating(rating);

        Mockito.verify(ratingRepositoryMock, times(1)).save(rating);

    }

    @Test(dataProvider = "rating-data")
    public void it_should_find_book_by_criteria(Rating rating, Book book, User user)
    {
        Optional<Rating> optionalRating = ratingService.findByBookIdAndUserId(book.getId(), user.getId());

        Mockito.verify(ratingRepositoryMock, times(1)).
                findByBookIdAndUserId(book.getId(), user.getId());
    }

    @Test(dataProvider = "rating-data")
    public void it_should_get_rating(Rating rating, Book book, User user)
    {
        double rating1 = ratingService.getRating(book);

        Mockito.verify(ratingRepositoryMock, times(1)).findByBook(book);
        Assert.assertEquals(rating1, NaN, 0.0);
    }

    @Test(dataProvider = "rating-data")
    public void it_should_get_all_ratings(Rating rating, Book book, User user)
    {
        List<Rating> list = ratingService.getAllBookRating(book);

        Mockito.verify(ratingRepositoryMock, times(1)).findByBook(book);
    }

    @Test(dataProvider = "rating-data")
    public void it_should_delete_ratings(Rating rating, Book book, User user)
    {
        ratingService.deleteRating(rating);

        Mockito.verify(ratingRepositoryMock,times(1)).delete(rating);
    }
}
