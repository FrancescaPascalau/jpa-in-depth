package com.francesca.pascalau.repository;

import com.francesca.pascalau.entities.Contract;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ContractRepository extends CrudRepository<Contract, Long> {

    Optional<Contract> findById(Long id);
}
