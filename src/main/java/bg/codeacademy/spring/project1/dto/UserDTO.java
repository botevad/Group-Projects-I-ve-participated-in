package bg.codeacademy.spring.project1.dto;

import bg.codeacademy.spring.project1.model.IdEntity;

import javax.validation.constraints.NotBlank;

public class UserDTO extends IdEntity
{
  @NotBlank(message = "Username cannot be blank or null")
  public String username;

  public String getUsername() {
    return username;
  }

  public UserDTO setUsername(String username) {
    this.username = username;
    return this;
  }
}
