package com.learn.spring_boot.user;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository _userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        _userRepository = userRepository;
    }

    public List<User> findAll(){
        return _userRepository.findAll();
    }

    public User create(String name, String email, LocalDate dob){
        User user = new User(
                name,
                email,
                dob,
                dob.until(LocalDate.now()).getYears()
        );

        return _userRepository.save(user);
    }

    public User update(Long id, String name, String email, LocalDate dob){
        Optional<User> query = _userRepository.findById(id);

        if(query.isEmpty()){
            throw new EntityNotFoundException();
        }

        User user = query.get();

        user.setName(name);
        user.setEmail(email);
        user.setDob(dob);
        user.setAge(dob.until(LocalDate.now()).getYears());


        return _userRepository.save(user);
    }

    public void delete(Long id) {
        _userRepository.deleteById(id);
    }
}
