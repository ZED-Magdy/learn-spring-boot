package com.learn.spring_boot.user;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    public Long id;
    public String name;
    public String email;
    public LocalDate dob;
    public int age;
}
