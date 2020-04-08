package bg.codeacademy.spring.progect1.controller;

import bg.codeacademy.spring.project1.controller.UserController;
import bg.codeacademy.spring.project1.dto.UserRegistration;
import bg.codeacademy.spring.project1.model.User;
import bg.codeacademy.spring.project1.service.UserService;
import org.mockito.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.URISyntaxException;

public class UserControllerUnitTest
{
  @InjectMocks
  UserController    userController;
  @Mock
  UserRegistration  userRegistration;
  @Mock
  UserService       userService;

  @BeforeClass
  public void setup()
  {
    MockitoAnnotations.initMocks(this);
    userRegistration.username = "Kuncho";
  }


  @Test
  public void createUserForExistingUserReturnsConflictTest() throws URISyntaxException
  {
    Mockito
        .when(userService.getUser(Mockito.anyString()))
        .thenReturn(new User());

    ResponseEntity<?> responseEntity = userController.createUser(userRegistration);
    Assert.assertEquals(responseEntity.getStatusCode(), HttpStatus.CONFLICT);
  }

  @Test
  public void createUserForNonExistingUserReturnsCreateTest() throws URISyntaxException
  {
    Mockito
        .when(userService.getUser(Mockito.anyString()))
        .thenReturn(null);

    ResponseEntity<?> responseEntity = userController.createUser(userRegistration);
    Assert.assertEquals(responseEntity.getStatusCode(), HttpStatus.CREATED);
  }


  @Test
  public void deleteNonExistingUserReturnsNotFoundTest()
  {
    Mockito
        .when(userService.deleteUser(Mockito.anyString()))
        .thenReturn(false);

    ResponseEntity<?> responseEntity = userController.deleteUser(Mockito.anyString());
    Assert.assertEquals(responseEntity.getStatusCode(), HttpStatus.NOT_FOUND);
  }

  @Test
  public void deleteExistingUserReturnsOKTest()
  {
    Mockito
        .when(userService.deleteUser(Mockito.anyString()))
        .thenReturn(true);

    ResponseEntity<?> responseEntity = userController.deleteUser(userRegistration.username);
    Assert.assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
  }

 }
