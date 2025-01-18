package com.learn.spring_boot.user;

import java.time.LocalDate;

public class UserDto {
    public Long id;
    public String name;
    public String email;
    public LocalDate dob;
    public int age;
    
    public Long getId() {
      return id;
    }
    public void setId(Long id) {
      this.id = id;
    }
    public String getName() {
      return name;
    }
    public void setName(String name) {
      this.name = name;
    }
    public String getEmail() {
      return email;
    }
    public void setEmail(String email) {
      this.email = email;
    }
    public LocalDate getDob() {
      return dob;
    }
    public void setDob(LocalDate dob) {
      this.dob = dob;
    }
    public int getAge() {
      return age;
    }
    public void setAge(int age) {
      this.age = age;
    }

    
}
