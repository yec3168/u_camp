package com.ucamp.myspringboot.controller;

import com.ucamp.myspringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

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