package com.francesca.pascalau.port;

import com.francesca.pascalau.model.BillDto;
import com.francesca.pascalau.model.ContractDto;
import com.francesca.pascalau.request.ContractRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ContractServicePort {

    void create(ContractDto contractDto);

    List<BillDto> findAllBills(Long id);

    Page<ContractDto> findAllContractsWithBills(Pageable pageable);

    Page<ContractDto> findAll(ContractRequest request, Pageable pageable);

    List<ContractDto> findAllByCustomerId(Long customerId);

    ContractDto findById(Long contractId);
}
