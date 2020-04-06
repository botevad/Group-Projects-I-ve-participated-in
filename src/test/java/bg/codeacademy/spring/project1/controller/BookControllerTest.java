package bg.codeacademy.spring.project1.controller;

import bg.codeacademy.spring.project1.model.Book;
import bg.codeacademy.spring.project1.service.BookService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.web.servlet.function.RequestPredicates.param;

@SpringBootTest
@AutoConfigureMockMvc
public class BookControllerTest {

    @MockBean
    BookService bookService;

    ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private MockMvc mockMvc;


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
