package com.ucamp.mymisson.repository;

import com.ucamp.mymisson.entity.CustomerEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class CustomerRepositoryTest {
    @Autowired
    private CustomerRepository customerRepository;

    @Test
    @Rollback(value = false) // rollback 하게 됨
    void repositoryTest(){
        // 1. 등록 테스트
        CustomerEntity customer = new CustomerEntity();
        customer.setEmail("test4@test.com");
        customer.setAge(2);
        CustomerEntity saved = customerRepository.save(customer);

        assertThat(saved).isNotNull();
        assertThat(saved.getEmail()).isEqualTo("test1@test.com");

        // 2. id값과 일치하는 Customer 가져오기.
        Optional<CustomerEntity> op = customerRepository.findById(4L);

        if(op.isPresent()){
            CustomerEntity exist = op.get();
            assertThat(exist.getId()).isEqualTo(4L);


            // 3. update;
            exist.setAge(100);
        }
    }

}