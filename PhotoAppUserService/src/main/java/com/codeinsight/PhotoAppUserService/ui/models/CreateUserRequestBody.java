package com.codeinsight.PhotoAppUserService.ui.models;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CreateUserRequestBody {

    @NotNull(message = "First Name cannot be null")
    @Size(min = 2, message = "First Name has to be at least 2 characters")
    private String firstName;

    @NotNull(message = "Last Name cannot be null")
    @Size(min = 2, message = "Last Name has to be at least 2 characters")
    private String lastName;

    @NotNull(message = "Password  cannot be null")
    @Size(min = 8, max = 16, message = "Password has to be at between 8 and 16 characters")
    private String password;

    @Email
    @NotNull(message = "Email cannot be null")
    private String email;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
