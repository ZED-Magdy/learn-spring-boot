package com.learn.spring_boot.user;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class UserService {

    public List<User> findAll(){
        return List.of(new User(
                1L,
                "ZED",
                "zed@zed.com",
                LocalDate.of(1998, 6, 24),
                26)
        );
    }
}
