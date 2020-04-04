package bg.codeacademy.spring.project1.dto;

import javax.validation.constraints.NotBlank;

public class UserDTO
{
  @NotBlank(message = "Username cannot be blank or null")
  private String username;

  public String getUsername()
  {
    return username;
  }

  public void setUsername(String username)
  {
    this.username = username;
  }
}
