package com.francesca.pascalau.repository;

import com.francesca.pascalau.entities.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ContractRepository extends JpaRepository<Contract, Long>, ContractCustomRepository {

    Optional<Contract> findById(Long id);

    @Query("FROM Contract c JOIN c.customer cu JOIN FETCH c.bills b WHERE cu.id = :customerId")
    List<Contract> findByCustomerId(Long customerId);

    Page<Contract> findByBillsExists(Pageable pageable);
}
