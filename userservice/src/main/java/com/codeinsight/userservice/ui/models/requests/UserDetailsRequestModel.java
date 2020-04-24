package com.codeinsight.userservice.ui.models.requests;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class UserDetailsRequestModel {
    @NotNull(message = "firstName cannot be Null")
    @Size(min = 2,message = "firstName cannot be less than 2 characters")
    private String firstName;

    @NotNull(message = "lastName cannot be Null")
    @Size(min = 2,message = "lastName cannot be less than 2 characters")
    private String lastName;

    @NotNull(message = "email cannot be Null")
    @Email
    private String email;

    @NotNull(message = "password cannot be Null")
    @Size(min=8 ,max = 16, message = "Password must be greater than 8 and less than 16 characters")
    private String password;
}
