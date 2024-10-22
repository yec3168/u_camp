package com.ucamp.mymisson.controller;

import com.ucamp.mymisson.dto.CustomerReqForm;
import com.ucamp.mymisson.dto.CustomerRequest;
import com.ucamp.mymisson.dto.CustomerResponse;
import com.ucamp.mymisson.service.CustomerService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerThymeleafController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/index")
    public String index(Model model){
        model.addAttribute("customers", customerService.getCustomers());
        return "index";
    }

    @GetMapping("/signup")
    public String showAddForm(Model model){
        model.addAttribute("customerRequest", new CustomerRequest());
        return "add-customer";
    }

    @PostMapping("/addCustomer")
    public String addCustomer(@Valid CustomerRequest customerRequest,
                              BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "add-customer";
        }

        customerService.saveCustomer(customerRequest);

        return "redirect:/index";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id")Long id, Model model){
        CustomerResponse customer = customerService.getCustomerById(id);
        model.addAttribute("customer", customer);
        return "update-customer";
    }

    @PostMapping("/updateCusotmer/{id}")
    public String updateCustomer(@PathVariable("id") Long id,
                                 @Valid @ModelAttribute("customer") CustomerReqForm customerReqForm,
                                 BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "update-customer";
        }

        customerService.updateCustomer(customerReqForm.getEmail(), modelMapper.map(customerReqForm, CustomerRequest.class));

        return "redirect:/index";
    }


    @GetMapping("/deleteCustomer/{id}")
    public String deleteCustomer(@PathVariable("id") Long id){
        customerService.deleteCustomer(id);
        return "redirect:/";
    }

}
