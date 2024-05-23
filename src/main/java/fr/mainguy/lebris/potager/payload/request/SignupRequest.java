package fr.mainguy.lebris.potager.payload.request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;


@Getter
@Setter
@Data
public class SignupRequest {

  private String username;

  private String email;

  private Set<String> role;

  private String password;

}
