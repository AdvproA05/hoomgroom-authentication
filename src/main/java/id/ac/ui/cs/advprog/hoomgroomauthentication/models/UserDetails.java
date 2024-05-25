package id.ac.ui.cs.advprog.hoomgroomauthentication.models;

public interface UserDetails {
    String getFullname();
    void setFullname(String fullname);
    String getDob();
    void setDob(String dob);
    String getSex();
    void setSex(String sex);
    String getUsername();
    void setUsername(String username);
    String getEmail();
    void setEmail(String email);
    String getPassword();
    void setPassword(String password);
}
