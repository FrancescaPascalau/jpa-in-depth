package com.francesca.pascalau.repository;

import com.francesca.pascalau.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Concept: Soft Delete
 * Description: performs an update process to mark some data as deleted instead of physically deleting it from a table.
 * Solution: @SQLDelete with a where clause that updates an entity with a deleted value.
 * (@Modifying and @Transactional needed on repository method to perform the delete action)
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findById(Long id);

    @Modifying
    @Transactional
    void deleteById(Long id);
}
