package com.example.car_shop.dto;

import lombok.Data;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class UserForm {
    @NotEmpty(message = "Email cannot be empty and should have:")
    @Size(min = 7, max = 50)
    private String email;

    @NotEmpty(message = "password can not be empty and should have:")
    @Size(min = 3, max = 25)
    private String password;
}
