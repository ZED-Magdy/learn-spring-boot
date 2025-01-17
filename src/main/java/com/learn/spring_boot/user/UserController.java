package com.learn.spring_boot.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @PostMapping
    public User Store(@RequestBody UserDto dto){
        return _userService.create(dto.name, dto.email, dto.dob);
    }

    @PutMapping("{id}")
    public User Update(@PathVariable("id") Long id , @RequestBody UserDto dto){
        return _userService.update(id, dto.name, dto.email, dto.dob);
    }

    @DeleteMapping("{id}")
    public Map<String, String> Destroy(@PathVariable("id") Long id){
        _userService.delete(id);

        Map<String, String> response = new HashMap<>();
        response.put("message", "Deleted");

        return response;
    }
}
