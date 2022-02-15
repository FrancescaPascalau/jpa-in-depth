package com.francesca.pascalau.repository;

import com.francesca.pascalau.entities.Contract;
import com.francesca.pascalau.request.ContractRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;

@Repository
@RequiredArgsConstructor
public class ContractCustomRepositoryImpl implements ContractCustomRepository {

    private final EntityManager entityManager;

    @Override
    public Page<Contract> findAll(ContractRequest request, Pageable pageable) {
        var query = entityManager.createQuery(createQuery(request), Contract.class);
        createParams(query, request);
        query.setFirstResult((request.getPageNumber() - 1) * request.getPageSize());
        query.setMaxResults(request.getPageSize());

        var contracts = query.getResultList();
        var count = count(request);

        return new PageImpl<>(
                contracts,
                PageRequest.of(request.getPageNumber() - 1, request.getPageSize()),
                count);
    }

    private String createQuery(ContractRequest request) {
        var query = new StringBuilder();
        query.append("FROM Contract c WHERE ");

        if (request.getCustomerId() != null)
            query.append("c.id = :customer_id AND");

        return query.substring(0, query.toString().length() - 4);
    }

    private void createParams(Query query, ContractRequest request) {
        if (request.getCustomerId() != null)
            query.setParameter("customer_id", request.getCustomerId());
    }

    private Long count(ContractRequest request) {
        var query = entityManager.createQuery("SELECT COUNT(c.id)" + createQuery(request), Long.class);
        createParams(query, request);

        return query.getSingleResult();
    }
}
