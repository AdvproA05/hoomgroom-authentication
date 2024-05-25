package id.ac.ui.cs.advprog.hoomgroomauthentication.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "app_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String fullname;
    private String dob;
    private String sex;
    @Column(unique = true)
    private String username;
    @Column(unique = true)
    private String email;
    private String password;

    public User(String fullname, String dob, String sex, String username, String email, String password) {
        this.fullname = fullname;
        this.dob = dob;
        this.sex = sex;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User() {
        super();
    }

}
