package bg.codeacademy.spring.progect1.controller;


import bg.codeacademy.spring.project1.Project1Application;
import bg.codeacademy.spring.project1.dto.UserRegistration;
import bg.codeacademy.spring.project1.enums.Role;
import bg.codeacademy.spring.project1.model.Book;
import io.restassured.RestAssured;
import net.minidev.json.JSONObject;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = Project1Application.class)
@ActiveProfiles("dev")
public class BookControllerTest extends AbstractTestNGSpringContextTests {

    @LocalServerPort
    int port;

    @BeforeClass(alwaysRun = true, dependsOnMethods = "springTestContextPrepareTestInstance")
    protected void setupRestAssured()
    {
        RestAssured.port = port;
    }

    @DataProvider(name = "book-provider")
    public Object[][] dataProviderMethod()
    {
        Book book1 = new Book();
        book1.setId(19);
        book1.setYear(2019);
        book1.setAuthor("Georgi");
        book1.setTitle("Book");

        Book book2 = new Book();
        book2.setId(10);
        book2.setYear(2015);
        book2.setAuthor("Georgi");
        book2.setTitle("Title");

        UserRegistration admin = new UserRegistration();
        admin.username = "admin";
        admin.password = "123456";
        admin.role = Role.ADMIN;

        return new Object[][]
                {
                        {book1, admin,  HttpStatus.CREATED}
                };
    }


    @Test(dataProvider = "book-provider")
    public void add_book_request(Book book, UserRegistration user,  HttpStatus status)
    {
        JSONObject userParams = new JSONObject();
        userParams.put("password", "test");
        userParams.put("username", "created-user");
        userParams.put("role", "ADMIN");


        RestAssured.given().auth()
            .basic(user.username, user.password).params("id", book.getId(), "year",
                book.getYear(), "author", book.getAuthor(), "title", book.getTitle()).when().post("/api/v1/books").
                then().assertThat().statusCode(status.value());
    }

    @Test
    public void get_all_books_request()
    {
        RestAssured.given().when().get("/api/v1/books").then().statusCode(200);
    }
}
