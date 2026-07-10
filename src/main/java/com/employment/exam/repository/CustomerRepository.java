package com.employment.exam.repository;

import com.employment.exam.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
    Customer getCustomerByCustomerEmail(String customerEmail);
    Customer getCustomerById(Long id);
};
