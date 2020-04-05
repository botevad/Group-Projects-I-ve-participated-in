package bg.codeacademy.spring.progect1.controller;

import bg.codeacademy.spring.project1.dto.UserDTO;
import bg.codeacademy.spring.project1.dto.UserRegistration;
import bg.codeacademy.spring.project1.model.User;
import bg.codeacademy.spring.project1.service.UserService;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.BeanUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class UserControllerTest
{
  @Mock
  private UserService userServiceMock;

  @BeforeTest
  public void setup()
  {
    MockitoAnnotations.initMocks(this);
  }

  @DataProvider(name = "data-provider")
  public Object[][] dataProviderMethod()
  {
    UserDTO userDto = new UserDTO();
    userDto.username = null;

    return new Object[][]{
        {userDto}
    };
  }

  //TODO
//  @Test(dataProvider = "data-provider")
//  public void addUserTest(UserRegistration userRegistration)
//  {
//    userServiceMock.createUser(userRegistration);
//  }
}
