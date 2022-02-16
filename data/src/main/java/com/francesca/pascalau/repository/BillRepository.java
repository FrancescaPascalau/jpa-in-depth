package com.francesca.pascalau.repository;

import com.francesca.pascalau.entities.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface BillRepository extends JpaRepository<Bill, Long> {

    Optional<Bill> findById(Long id);

    Optional<Bill> findByAmountBetween(Long min, Long max);

    @Modifying
    @Transactional
    @Query("UPDATE Bill b SET b.amount = b.amount + :amount WHERE b.id = :id")
    void updateAmount(Long id, Long amount);
}
