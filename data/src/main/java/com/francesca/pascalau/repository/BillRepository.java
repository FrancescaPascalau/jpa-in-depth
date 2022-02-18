package com.francesca.pascalau.repository;

import com.francesca.pascalau.entities.Bill;
import com.francesca.pascalau.entities.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Concept: JPQL and SQL
 * Description: By default, the query definition uses JPQL (class definitions for fields).
 * Solution: Set nativeQuery = true to enable SQL language instead of JPQL.
 */
public interface BillRepository extends JpaRepository<Bill, Long> {

    Optional<Bill> findById(Long id);

    Optional<Bill> findByAmountBetweenAndType(Long minAmount, Long maxAmount, Type type);

    @Modifying
    @Transactional
    @Query("UPDATE Bill b SET b.amount = b.amount + :amount WHERE b.id = :id")
    void updateAmount(Long id, Long amount);
}
