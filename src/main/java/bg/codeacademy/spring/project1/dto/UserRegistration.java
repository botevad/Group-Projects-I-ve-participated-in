package bg.codeacademy.spring.project1.dto;

import javax.validation.constraints.NotNull;

public class UserRegistration extends UserDTO
{
  @NotNull
  public String password;


}
