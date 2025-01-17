package com.learn.spring_boot.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/users")
public class UserController {

    private final UserService _userService;

    @Autowired
    public UserController(UserService userService) {
        _userService = userService;
    }

    @GetMapping
    public List<User> Index(){
        return _userService.findAll();
    }
}
