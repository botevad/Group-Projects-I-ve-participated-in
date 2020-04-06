package bg.codeacademy.spring.project1.controller;

import bg.codeacademy.spring.project1.model.Book;
import bg.codeacademy.spring.project1.repository.BookRepository;
import bg.codeacademy.spring.project1.service.BookService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import org.aspectj.lang.annotation.Before;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.web.servlet.function.RequestPredicates.param;

@SpringBootTest
@AutoConfigureMockMvc
public class BookControllerTest extends AbstractTestNGSpringContextTests {


    ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    BookRepository bookRepositoryMock;

    @BeforeMethod
    public void init() {
        Book book = new Book();
        book.setTitle("aa");
        book.setAuthor("bb");
        book.setYear(2011);
        Mockito.when(bookRepositoryMock.findById(book.getId()).get().getTitle()).thenReturn("aa");
    }

    @Test
    public void get_book_test() throws Exception {
        mockMvc.perform((RequestBuilder) get("/api/v1/books")).andExpect(status().isOk()).
                andExpect(jsonPath("$.title").value("aa")).
                andExpect(jsonPath("$.author").value("bb"));

        Mockito.verify(bookRepositoryMock, times(1)).
                findByTitleContainingOrAuthorContaining("aa", "bb");
    }


    @Test
    public void it_should_return_created_book() throws Exception {
        Book book = new Book();
        book.setId(101);
        book.setTitle("Title");
        book.setAuthor("Author");
        book.setYear(2);

        // bookService.addBook(book);
      /*  given().
                param("id", 900).
                param("title","booky").
                param("author", "Ivan Penchev").
                param("year", 2012).
                when().get("/api/v1/books").then().
                body("id", "900") */

        mockMvc.perform(post("/api/v1/books").content(mapper.writeValueAsString(book)).
                contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andExpect(jsonPath("$.title").
                value(book.getTitle()));

    }

}
