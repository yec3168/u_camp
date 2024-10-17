package com.ucamp.mymisson.controller;

import com.ucamp.mymisson.entity.CustomerEntity;
import com.ucamp.mymisson.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customers")
public class CustomerBasicRestController {
    private CustomerRepository customerRepository;

    @PostMapping
    public CustomerEntity createCustomer(CustomerEntity customer){
        return null;
    }

    @GetMapping
    public List<CustomerEntity> getCustomers(){
        return customerRepository.findAll();
    }

    @GetMapping("/{id}")
    public CustomerEntity getCustomer(@PathVariable("id") Long id){
        return null;
    }

    @PutMapping("/{id}")
    public CustomerEntity updateCustomer(@PathVariable("id") Long id, @RequestBody CustomerEntity customer){
        return null;
    }
}
