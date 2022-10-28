package org.launchcode.spaday.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class User {
    @Size(min = 5, max =15, message="Usernames must be between 5 and 15 characters long.")
    @NotBlank(message="The username cannot be blank.")
    private String username;

    @Email(message="Email addresses must be entered in a valid format.")
    private String email;
    @Size(min=6, message="Passwords are required to be at least 6 characters.")
    @NotBlank(message="The password cannot be blank.")
    private String password;

    @NotNull(message ="Passwords do not match")
    private String verifyPassword;

    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
        checkPassword();
    }

    public User() {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    private void checkPassword(){
        if (password !=null && verifyPassword !=null && !password.equals(verifyPassword)){
            verifyPassword = null;
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        checkPassword();
    }
}
