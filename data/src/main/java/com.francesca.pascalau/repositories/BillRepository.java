package com.francesca.pascalau.repositories;

import com.francesca.pascalau.entities.Bill;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BillRepository extends CrudRepository<Bill, Long> {

    Optional<Bill> findById(Long id);
}
