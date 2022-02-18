package com.francesca.pascalau.repository;

import com.francesca.pascalau.entities.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.jpa.repository.EntityGraph.*;

/**
 * Concept: N+1 problem
 * Description: N+1 problem is a performance issue in ORM that fires multiple select queries
 * (N+1, N = nr. record in table) for a single select query.
 * Solution:
 * 1. @EntityGraph - the JPA provider loads all the graph in one select query and then avoids fetching with more SELECT queries.
 * 2. Query with Fetch Join - allows associations of values to be initialized along with their parent using a single select.
 */
public interface ContractRepository extends JpaRepository<Contract, Long>, ContractCustomRepository {

    Optional<Contract> findById(Long id);

    @EntityGraph(type = EntityGraphType.FETCH, attributePaths = {"Contract", "customer"})
    Page<Contract> findAll(Pageable pageable);

    @Query("FROM Contract c JOIN c.customer cu JOIN FETCH c.bills b WHERE cu.id = :customerId")
    List<Contract> findByCustomerId(Long customerId);

    /**
     * Concept: Pagination
     * Description: When finding all records that meet a specific criteria there can be performance issue as soon as the number of records increases.
     * Solution: Using Pageable when can retrieve data by setting a limit on how many recorde we see at a time.
     */
    Page<Contract> findByBillsExists(Pageable pageable);
}
