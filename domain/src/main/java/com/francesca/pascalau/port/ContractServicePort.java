package com.francesca.pascalau.port;

import com.francesca.pascalau.model.BillDto;
import com.francesca.pascalau.model.ContractDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ContractServicePort {

    void create(ContractDto contractDto);

    List<BillDto> findAllBills(Long id);

    List<ContractDto> findAllContractsWithBills(Pageable pageable);
}
