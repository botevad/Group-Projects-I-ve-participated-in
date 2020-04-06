package bg.codeacademy.spring.project1.service;

import bg.codeacademy.spring.project1.model.Book;
import bg.codeacademy.spring.project1.repository.BookRepository;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Optional;

import static org.mockito.Mockito.mock;

@SpringBootTest
public class BookServiceImplTest  {

    @Autowired
    BookService bookService;

@Bean
    public BookRepository mockMyRepository()
{
    return mock(BookRepository.class);
}


    @Test
    public void addBookTest() {
        Book book = new Book();
        book.setId(44);
        book.setTitle("2008");
        book.setAuthor("Ivaylo Mihailov");
        book.setYear(2007);

        bookService.addBook(book);

        Assert.assertEquals(mockMyRepository().findById(book.getId()).get().getAuthor(), "Ivaylo Mihailov");
    }
}
