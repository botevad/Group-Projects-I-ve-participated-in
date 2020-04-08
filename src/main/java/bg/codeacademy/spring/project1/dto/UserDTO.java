package bg.codeacademy.spring.project1.dto;

import javax.validation.constraints.NotBlank;

public class UserDTO
{
  @NotBlank(message = "Username cannot be blank or null")
  public String username;

  public void setUsername(String username)
  {
    this.username = username;
  }
}
