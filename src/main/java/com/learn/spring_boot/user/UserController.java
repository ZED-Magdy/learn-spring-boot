package com.learn.spring_boot.user;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "api/v1/users")
public class UserController {

    private final UserService _userService;

    public UserController(UserService userService) {
        _userService = userService;
    }

    @GetMapping
    public List<UserDto> Index(){
        return _userService.findAll();
    }

    @SuppressWarnings("rawtypes")
    @PostMapping
    public ResponseEntity Store(@Valid @RequestBody UserRequestDto dto) {
        try {
            UserDto user = _userService.create(dto.name, dto.email, dto.dob);
            return ResponseEntity.created(URI.create("/api/v1/users")).body(user);
        } catch (IllegalArgumentException e) {
            Map<String, String> response = new HashMap<>();
            response.put("message", e.getMessage());

            return ResponseEntity.badRequest().body(response);
        }
    }

    @PutMapping("{id}")
    public UserDto Update(@PathVariable Long id , @Valid @RequestBody UserRequestDto dto){
        return _userService.update(id, dto.name, dto.email, dto.dob);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Map<String, String>> Destroy(@PathVariable Long id){
        _userService.delete(id);

        Map<String, String> response = new HashMap<>();
        response.put("message", "Deleted");

        return ResponseEntity.ok().body(response);
    }
}
