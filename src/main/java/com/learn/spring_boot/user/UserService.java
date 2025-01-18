package com.learn.spring_boot.user;

import jakarta.persistence.EntityNotFoundException;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository _userRepository;
    private final ModelMapper _mapper;

    public UserService(UserRepository userRepository, ModelMapper mapper) {
        _userRepository = userRepository;
        _mapper = mapper;
    }

    public List<UserDto> findAll(){
        List<User> users = _userRepository.findAll();
        return users
                .stream()
                .map(user -> _mapper.map(user, UserDto.class))
                .collect(Collectors.toList());
    }

    public UserDto create(String name, String email, LocalDate dob) {
        Optional<User> existingUser = _userRepository.findByEmail(email);

        if(existingUser.isPresent()){
            throw new IllegalArgumentException("Email is already in use");
        }

        User user = new User(
                name,
                email,
                dob,
                dob.until(LocalDate.now()).getYears()
        );

        _userRepository.save(user);

        return _mapper.map(user, UserDto.class);
    }

    public UserDto update(Long id, String name, String email, LocalDate dob){
        Optional<User> query = _userRepository.findById(id);

        if(query.isEmpty()){
            throw new EntityNotFoundException();
        }

        User user = query.get();

        user.setName(name);
        user.setEmail(email);
        user.setDob(dob);
        user.setAge(dob.until(LocalDate.now()).getYears());


        User updatedUser = _userRepository.save(user);

        return _mapper.map(updatedUser, UserDto.class);
    }

    public void delete(Long id) {
        _userRepository.deleteById(id);
    }
}
