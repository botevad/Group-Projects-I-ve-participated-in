package bg.codeacademy.spring.project1.dto;

import bg.codeacademy.spring.project1.model.IdEntity;

public class UserDTO extends IdEntity
{

  private String username;

  public UserDTO()
  {

  }


  public String getUsername()
  {
    return username;
  }

  public void setUsername(String username)
  {
    this.username = username;
  }
}
