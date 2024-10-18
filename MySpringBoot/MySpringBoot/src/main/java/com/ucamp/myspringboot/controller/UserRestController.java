package com.ucamp.myspringboot.controller;

import com.ucamp.myspringboot.entity.User;
import com.ucamp.myspringboot.exception.BusinessException;
import com.ucamp.myspringboot.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor // 자동 constructor injection 방식을 해줌.
@RequestMapping("/user")
public class UserRestController {

    private final UserRepository userRepository;

    // constructor injection 방법
//    public UserRestController(UserRepository userRepository) {=
//        this.userRepository = userRepository;
//    }

    @PostMapping
    public User addUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping({"/{id}"})
    public User getUser(@PathVariable("id") Long id) {
        //Optional<User> user = userRepository.findById(id);
        return getUserFound(id);
    }


    @GetMapping
    public List<User> getUsers() {
        return userRepository.findAll();

    }

    @PatchMapping("/{email}/")
    public User updateUser(@PathVariable String email, @RequestBody User userDetail) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new BusinessException("User Not Found", HttpStatus.NOT_FOUND));;

        user.setName(userDetail.getName());
        return userRepository.save(user);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id")Long id){
        User user = getUserFound(id);

        userRepository.delete(user);

        return ResponseEntity.ok("ID : " + id + " User가 삭제 되었습니다.");
    }

    public User getUserFound(Long id) {
        return userRepository.findById(id).orElseThrow(() ->
                new BusinessException("User Not Found", HttpStatus.NOT_FOUND)
        );
    }
}