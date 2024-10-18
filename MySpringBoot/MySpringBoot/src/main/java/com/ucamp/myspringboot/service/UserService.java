package com.ucamp.myspringboot.service;

import com.ucamp.myspringboot.dto.UserReqDTO;
import com.ucamp.myspringboot.dto.UserResDTO;
import com.ucamp.myspringboot.entity.User;
import com.ucamp.myspringboot.exception.BusinessException;
import com.ucamp.myspringboot.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;


    public UserResDTO addUser(UserReqDTO userReqDTO){
        // UserMapper을 사용해서 UserReqDTO -> User로 만듦.
        User user = modelMapper.map(userReqDTO, User.class);

        // Repository에 저장
        userRepository.save(user);

        // Entity를 UserResDTO로 변경.
        return modelMapper.map(user, UserResDTO.class);
    }


    public UserResDTO getUser(Long id){
         return  userRepository.findById(id)
                 // optional map
                        .map( user -> modelMapper.map(user, UserResDTO.class))
                        .orElseThrow(
                            () -> new BusinessException("User not Found", HttpStatus.NOT_FOUND)
                         );


    }

    public List<UserResDTO> getUserList(){
        List<User> userList = userRepository.findAll();
        return userList.stream() // Stream<User>로 바뀜.
                .map( user -> modelMapper.map(user, UserResDTO.class)) // Stream<UserResDTO>
                .toList(); // List<UserResDTO>

        //        List<UserResDTO> userResDTOList = new ArrayList<>();
        //        userList.forEach( user -> {
        //            UserResDTO userResDTO = modelMapper.map(user,  UserResDTO.class);
        //            userResDTOList.add(userResDTO);
        //        });
        //
        //        return  userResDTOList;
    }

    public UserResDTO getUserByEmail(String email){
        return userRepository.findByEmail(email)
                .map( user -> modelMapper.map(user, UserResDTO.class))
                .orElseThrow(
                        () -> new BusinessException("User not Found", HttpStatus.NOT_FOUND)
                );
    }

}
