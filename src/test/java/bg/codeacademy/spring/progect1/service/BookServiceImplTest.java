package bg.codeacademy.spring.progect1.service;

import bg.codeacademy.spring.project1.model.Book;
import bg.codeacademy.spring.project1.repository.BookRepository;
import bg.codeacademy.spring.project1.service.BookService;
import bg.codeacademy.spring.project1.service.BookServiceImpl;
import org.mockito.Mockito;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;


public class BookServiceImplTest {


    BookRepository bookRepositoryMock = mock(BookRepository.class);

    BookService bookService = new BookServiceImpl(bookRepositoryMock);

    @DataProvider(name = "book-data")
    public Object[][] dataProviderMethod()
    {
        Book book1 = new Book();
        book1.setYear(3011);
        book1.setId(212);
        book1.setAuthor("Ivan");
        book1.setTitle("sasasfga");

        Book book2 = new Book();
        book2.setYear(30111);
        book2.setId(123);
        book2.setAuthor("Ivsagaan");
        book2.setTitle("xx1");

        Book book3 = new Book();
        book3.setYear(201);
        book3.setId(142);
        book3.setAuthor("Ivan ss");
        book3.setTitle("ssl");

        return new Object[][]
                {
                        {book1}, {book2}, {book3}
                };
    }


    @Test(dataProvider = "book-data")
    public void it_should_save_book(Book book) {

        Book savedBook = bookService.addBook(book);

        Mockito.verify(bookRepositoryMock, times(1)).save(book);

    }

    @Test(dataProvider = "book-data")
    public void it_should_remove_book(Book book)
    {

        bookService.removeBook(book.getId());

        Mockito.verify(bookRepositoryMock, times(1)).deleteById(book.getId());
    }

    @Test(dataProvider = "book-data")
    public void it_should_get_book(Book book)
    {

    Optional<Book> savedBook = bookService.getBook(book.getId());

        Mockito.verify(bookRepositoryMock, times(1)).findById(book.getId());
    }


  @Test
    public void should_get_all_books()
  {

      Optional<List<Book>> books = bookService.findAllBooks();

      Mockito.verify(bookRepositoryMock, times(1)).findAll();
  }

  @Test
    public void should_get_books_by_criteria()
  {
      String title = "bl";
      String author = "bla";
      Optional<List<Book>> books = bookService.findBookByCriteria(title, author);

      Mockito.verify(bookRepositoryMock, times(1)).
              findByTitleContainingOrAuthorContaining(title, author);
  }

}
