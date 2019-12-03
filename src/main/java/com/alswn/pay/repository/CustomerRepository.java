package com.alswn.pay.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alswn.pay.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, String> {

}
