package bg.codeacademy.spring.project1.dto;

import bg.codeacademy.spring.project1.enums.Role;

import javax.validation.constraints.NotBlank;

public class UserDTO
{
  @NotBlank(message = "Username cannot be blank or null")
  public String username;

  public String getUsername()
  {
    return username;
  }

  public void setUsername(String username)
  {
    this.username = username;
  }
}
