package com.ucamp.myspringboot.controller;

import com.ucamp.myspringboot.dto.UserReqDTO;
import com.ucamp.myspringboot.dto.form.UserReqFormDTO;
import com.ucamp.myspringboot.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserThymeleafController {

    @Autowired
    private UserService userService;

    @GetMapping("/signup")
    public String showingSignUpForm(UserReqFormDTO userReqFormDTO, Model model){
        model.addAttribute("user", userReqFormDTO);
        return "add-user";
    }

    @PostMapping("/adduser")
    public String addUser(@Valid UserReqFormDTO userReqFormDTO,
                          BindingResult bindingResult,
                          Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("user", userReqFormDTO);
        }

        return "index";
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


}