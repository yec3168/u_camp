package com.ucamp.myspringboot.controller;

import com.ucamp.myspringboot.dto.UserReqDTO;
import com.ucamp.myspringboot.dto.UserResDTO;
import com.ucamp.myspringboot.dto.form.UserReqFormDTO;
import com.ucamp.myspringboot.dto.form.UserReqUpdateForm;
import com.ucamp.myspringboot.service.UserService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserThymeleafController {

    @Autowired
    private UserService userService;

    @Autowired
    ModelMapper modelMapper;

    @GetMapping("/signup")
    public String showingSignUpForm( UserReqFormDTO userReqFormDTO, Model model){
        model.addAttribute("userReqFormDTO", new UserReqFormDTO());
        return "add-user";
    }

    @PostMapping("/adduser")
    public String addUser(@Valid UserReqFormDTO userReqFormDTO,
                          BindingResult bindingResult,
                          Model model){
        //add-user.html에서 서버쪽에 데이터를 보낼 때 json이 아니기 때문에 @Valid로만 받아도 됨
        if(bindingResult.hasErrors()){
//            model.addAttribute("user", userReqFormDTO);
            return "add-user";
        }
        userService.addUser(modelMapper.map( userReqFormDTO, UserReqDTO.class));

//        model.addAttribute("users", userService.getUserList());
//        return "index";

        return "redirect:/index";
    }

    @GetMapping("/thymeleaf")
    public String leaf(Model model) {

        model.addAttribute("name","basic");
        return "leaf";

    }

    @GetMapping("/index")
    public String index(Model model) {

        model.addAttribute("users", userService.getUserList());
        return "index";

    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        UserResDTO userResDTO = userService.getUser(id);
        model.addAttribute("user", userResDTO);
        return "update-user";
    }

    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") long id
            , @Valid @ModelAttribute("user") UserReqUpdateForm userReqUpdateForm
            , BindingResult bindingResult
            , Model model) {

        if(bindingResult.hasErrors()){
            model.addAttribute("user", userReqUpdateForm);
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "update-user";
        }

        userService.updateUserForm(userReqUpdateForm);

//        model.addAttribute("users", userService.getUserList());
//        return "index";

        return "redirect:/index";
    }


    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        userService.deleteUser(id);
        return "redirect:/index";
    }


}