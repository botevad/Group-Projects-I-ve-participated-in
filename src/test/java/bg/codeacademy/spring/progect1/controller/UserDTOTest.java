package bg.codeacademy.spring.progect1.controller;

import bg.codeacademy.spring.project1.service.UserService;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeTest;


public class UserDTOTest
{
  @Mock
  private UserService userServiceMock;

  @BeforeTest
  public void setup()
  {
    MockitoAnnotations.initMocks(this);
  }





}
