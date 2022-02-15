package com.francesca.pascalau.repository;

import com.francesca.pascalau.entities.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ContractRepository extends JpaRepository<Contract, Long>, ContractCustomRepository {

    Optional<Contract> findById(Long id);

    Page<Contract> findByBillsExists(Pageable pageable);
}
