package bg.codeacademy.spring.project1.service;

import bg.codeacademy.spring.project1.model.Book;
import bg.codeacademy.spring.project1.repository.BookRepository;
import io.restassured.RestAssured;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Optional;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
public class BookServiceImplTest  {

    @Test
    public void it_should_return_book()
    {
        Book book = new Book();
        book.setYear(2011);
        book.setAuthor("Ivan");
        book.setTitle("All");

        BookRepository mockito = mock(BookRepository.class);

        Book savedBook = mockito.save(book);

        Assert.assertEquals(savedBook.getTitle(), book.getTitle());

    }



}
