package com.francesca.pascalau.repository;

import com.francesca.pascalau.entities.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    Optional<Customer> findById(Long id);
}
