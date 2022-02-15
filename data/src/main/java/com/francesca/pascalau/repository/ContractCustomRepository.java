package com.francesca.pascalau.repository;

import com.francesca.pascalau.entities.Contract;
import com.francesca.pascalau.request.ContractRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ContractCustomRepository {

    Page<Contract> findAll(ContractRequest contractRequest, Pageable pageable);
}
