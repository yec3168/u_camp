package com.ucamp.myspringboot.repository;

import com.ucamp.myspringboot.entity.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class CustomerRepositoryTest {

    @Autowired
    CustomerRepository customerRepository;

    @Test
    @Rollback(value = false) // rollback 하게 됨
    void save_find(){
        Customer customer = new Customer();
        customer.setCustomerId("A013");
        customer.setCustomerName("eungchan");
        Customer saved = customerRepository.save(customer);

        assertThat(saved).isNotNull();
        assertThat(saved.getCustomerName()).isEqualTo("eungchan");


        Optional<Customer> optionalById = customerRepository.findById(1L);
        assertThat(optionalById).isNotEmpty();
        if(optionalById.isPresent()){
           Customer exist = optionalById.get();
            assertThat(exist.getCustomerId()).isEqualTo("A011");

            //update;
            exist.setCustomerName("springboot");

            //delete
            //customerRepository.delete(exist);

        }
    }
}