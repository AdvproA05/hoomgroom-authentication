package id.ac.ui.cs.advprog.hoomgroomauthentication.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupRequest {

    private String fullname;

    private String dob;

    private String sex;

    private String username;

    private String email;

    private String password;
}
