package com.ucamp.mymisson.service;

import com.ucamp.mymisson.dto.CustomerRequest;
import com.ucamp.mymisson.dto.CustomerResponse;
import com.ucamp.mymisson.entity.CustomerEntity;
import com.ucamp.mymisson.exception.BusinessException;
import com.ucamp.mymisson.repository.CustomerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Transactional
    public CustomerResponse saveCustomer(CustomerRequest customerRequest){
        CustomerEntity customer = modelMapper.map( customerRequest, CustomerEntity.class);

        customerRepository.save(customer);

        return  modelMapper.map(customer, CustomerResponse.class);
    }

    public CustomerResponse getCustomerById(Long id){
        return customerRepository.findById(id)
                .map(customer -> modelMapper.map(customer, CustomerResponse.class))
                .orElseThrow(
                        () -> new BusinessException("Customer not Found", HttpStatus.NOT_FOUND)
                );
    }

    public List<CustomerResponse> getCustomers(){
        return customerRepository.findAll()
                .stream()
                .map(customer ->  modelMapper.map(customer, CustomerResponse.class))
                .toList();
    }

    public CustomerResponse getCustomerByEmail(String email){
        return customerRepository.findByEmail(email)
                .map(customer -> modelMapper.map(customer, CustomerResponse.class))
                .orElseThrow(
                        () -> new BusinessException("Customer not Found", HttpStatus.NOT_FOUND)
                );
    }

    @Transactional
    public CustomerResponse updateCustomer(String email,CustomerRequest customerRequest){
        CustomerEntity customer = customerRepository.findByEmail(email)
                .orElseThrow(
                        () -> new BusinessException("Customer not Found", HttpStatus.NOT_FOUND)
                );
        customer.setAge(Integer.parseInt(customerRequest.getAge()));
        customer.setEmail(customerRequest.getEmail());

        return modelMapper.map(customer, CustomerResponse.class);
    }

    @Transactional
    public CustomerResponse updateCustomer(Long id, CustomerRequest customerRequest){
        CustomerEntity customer = customerRepository.findById(id)
                .orElseThrow(
                        () -> new BusinessException("Customer not Found", HttpStatus.NOT_FOUND)
                );
        customer.setAge(Integer.parseInt(customerRequest.getAge()));
        customer.setEmail(customerRequest.getEmail());

        return modelMapper.map(customer, CustomerResponse.class);
    }

    @Transactional
    public void deleteCustomer(Long id){
        CustomerEntity customer = customerRepository.findById(id)
                .orElseThrow(
                        () -> new BusinessException("Customer not Found", HttpStatus.NOT_FOUND)
                );

        customerRepository.delete(customer);
    }

}
