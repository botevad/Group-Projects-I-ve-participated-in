package bg.codeacademy.spring.progect1.controller;

import bg.codeacademy.spring.project1.Project1Application;
import bg.codeacademy.spring.project1.dto.UserRegistration;
import bg.codeacademy.spring.project1.enums.Role;
import io.restassured.RestAssured;
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

public class UserControllerTest extends AbstractTestNGSpringContextTests
{
  @LocalServerPort
  int port;

  @BeforeClass(alwaysRun = true, dependsOnMethods = "springTestContextPrepareTestInstance")
  protected void setupRestAssured()
  {
    String port = System.getProperty("server.port");

    if (port == null) {
      RestAssured.port = 8080;
    }
    else {
      RestAssured.port = Integer.parseInt(port);
    }

    String baseHost = System.getProperty("server.host");

    if (baseHost == null) {
      baseHost = "http://localhost";
    }

    RestAssured.baseURI = baseHost;
  }

  @DataProvider(name = "user-provider")
  public Object[][] dataProviderMethod()
  {
    UserRegistration admin = new UserRegistration();
    admin.username = "admin";
    admin.password = "password";
    admin.role = Role.ADMIN;

    UserRegistration user = new UserRegistration();
    user.username = "user";
    user.password = "password";
    user.role = Role.USER;

    return new Object[][]{
        {admin, HttpStatus.OK},
        {user, HttpStatus.UNAUTHORIZED}
    };
  }

  @Test(dataProvider = "user-provider")
  public void testGetUsers(UserRegistration user, HttpStatus status)
  {
    RestAssured
        .given().auth()
        .basic(user.username, user.password)
        .when()
        .get("/api/v1/users")
        .then()
        .assertThat()
        .statusCode(status.value());
  }
}
