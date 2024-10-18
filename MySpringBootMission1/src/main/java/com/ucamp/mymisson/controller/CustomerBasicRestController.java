package com.ucamp.mymisson.controller;

import com.ucamp.mymisson.entity.CustomerEntity;
import com.ucamp.mymisson.exception.BusinessException;
import com.ucamp.mymisson.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

@RequestMapping("/customers")
public class CustomerBasicRestController {
    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping
    public CustomerEntity createCustomer(@RequestBody CustomerEntity customer){
        return customerRepository.save(customer);
    }

    @GetMapping
    public List<CustomerEntity> getCustomers(){
        return customerRepository.findAll();
    }

    @GetMapping("/{id}")
    public CustomerEntity getCustomer(@PathVariable("id") Long id){
        Optional<CustomerEntity> exist = customerRepository.findById(id);
        return exist.orElseThrow(
                () -> new BusinessException("Customer not Found", HttpStatus.NOT_FOUND)
        );
    }


    @GetMapping("/{email}/")
    public CustomerEntity getCustomerByEmail(@PathVariable("email")String email){
        Optional<CustomerEntity> exist = customerRepository.findByEmail(email);
        return exist.orElseThrow(
                () -> new BusinessException("Customer not Found", HttpStatus.NOT_FOUND)
        );
    }

    @PutMapping("/{id}")
    public CustomerEntity updateCustomer(@PathVariable("id") Long id, @RequestBody CustomerEntity customer){
        CustomerEntity exist = customerRepository.findById(id).orElseThrow(
                () -> new BusinessException("Customer not Found", HttpStatus.NOT_FOUND)
        );

        exist.setAge(customer.getAge());
        exist.setEmail(customer.getEmail());
        return customerRepository.save(exist);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCustoemr(@PathVariable("id") Long id){
        CustomerEntity exist = customerRepository.findById(id).orElseThrow(
                () -> new BusinessException("Customer nt Found", HttpStatus.NOT_FOUND)
        );

        customerRepository.delete(exist);

        return  ResponseEntity.ok().build();
    }
}
