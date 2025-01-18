package com.learn.spring_boot.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public class UserRequestDto {
    @NotBlank(message = "Name is required")
    public String name;
    @NotBlank(message = "Email is required")
    @Email(message = "Email should be a valid email")
    public String email;
    public LocalDate dob;
}
