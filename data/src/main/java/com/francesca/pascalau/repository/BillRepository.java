package com.francesca.pascalau.repository;

import com.francesca.pascalau.entities.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BillRepository extends JpaRepository<Bill, Long> {

    Optional<Bill> findById(Long id);

    Optional<Bill> findByAmountBetween(long min, long max);
}
