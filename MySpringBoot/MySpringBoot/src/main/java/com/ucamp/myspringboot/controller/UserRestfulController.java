package com.ucamp.myspringboot.controller;

import com.ucamp.myspringboot.dto.UserReqDTO;
import com.ucamp.myspringboot.dto.UserResDTO;
import com.ucamp.myspringboot.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserRestfulController {

    private final UserService userService;


    @PostMapping("/")  // ResponseEntity 예시
    public ResponseEntity<?> addUser2(@RequestBody UserReqDTO userReqDTO){
        UserResDTO user = userService.addUser(userReqDTO);

        return ResponseEntity.ok("ID : " + user.getId() + " User입니다." );
    }

    @PostMapping
    public UserResDTO addUser(@RequestBody UserReqDTO userReqDTO){
        return userService.addUser(userReqDTO);
    }

    //=================================================================
//    @GetMapping("/{id}/")
//    public ResponseEntity<?> getUser1(@PathVariable("id") Long id){
//        UserResDTO user= userService.getUser(id);
//
//        return ResponseEntity.ok("ID : " + user.getId() + " User입니다.");
//    }

    @GetMapping("/{id}")
    public UserResDTO getUser(@PathVariable("id")Long id){
        return userService.getUser(id);
    }

    @GetMapping
    public List<UserResDTO> getUserList(){
        return userService.getUserList();
    }


    @GetMapping("/{email}/")
    public UserResDTO getUserByEmail(@PathVariable("email")String email){
        return  userService.getUserByEmail(email);
    }
//    @GetMapping
//    public ResponseEntity<?> getUserList1(){
//        List<UserResDTO> userResDTOList= userService.getUserList();
//        return null;
//    }

    @PutMapping("/{id}")
    public UserResDTO updateUser(@PathVariable("id") Long id, @RequestBody UserReqDTO userReqDTO){
        return  userService.updateUser(id, userReqDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id){
        userService.deleteUser(id);

        return ResponseEntity.ok("Id : " +id  + " User을 삭제되었습니다.");
    }


}
