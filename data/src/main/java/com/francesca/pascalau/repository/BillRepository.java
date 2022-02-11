package com.francesca.pascalau.repository;

import com.francesca.pascalau.entities.Bill;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface BillRepository extends CrudRepository<Bill, Long> {

    Optional<Bill> findById(Long id);
}
