package com.ucamp.myspringboot.repository;

import com.ucamp.myspringboot.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository                                             // < 엔티티, pk >
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    // customerId
    Optional<Customer> findByCustomerId(String customerId);

    List<Customer> findByCustomerName(String customerName);
}
