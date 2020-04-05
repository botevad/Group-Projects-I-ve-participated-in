package bg.codeacademy.spring.project1.dto;

import bg.codeacademy.spring.project1.enums.Role;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserRegistration extends UserDTO
{
  @NotBlank
  @Size(min = 3, max = 50)
  public String password;
  @NotNull
  public Role   role;

}
