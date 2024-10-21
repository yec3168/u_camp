package com.ucamp.mymisson.controller;

import com.ucamp.mymisson.dto.CustomerRequest;
import com.ucamp.mymisson.dto.CustomerResponse;
import com.ucamp.mymisson.repository.CustomerRepository;
import com.ucamp.mymisson.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping
    public CustomerResponse saveCustomer(@RequestBody CustomerRequest customerRequest){
        return customerService.saveCustomer(customerRequest);
    }

    @GetMapping("/{id}")
    public CustomerResponse getCustomerById(@PathVariable Long id){
        return customerService.getCustomerById(id);
    }

    @GetMapping
    public List<CustomerResponse> getCustomers(){
        return customerService.getCustomers();
    }

    @GetMapping("/{email}/")
    public CustomerResponse getCustomerByEmail(@PathVariable("email")String email){
        return customerService.getCustomerByEmail(email);
    }

    @PutMapping("/{email}/")
    public CustomerResponse updateCustomer(@PathVariable("email")String email, @RequestBody CustomerRequest customerRequest){
        return customerService.updateCustomer(email, customerRequest);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable("id")Long id){
       customerService.deleteCustomer(id);

       return ResponseEntity.ok(id+ " 번째 Customer가 삭제되었습니다.");
    }
}
