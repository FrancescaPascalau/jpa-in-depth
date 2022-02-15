package com.francesca.pascalau.adapters;

import com.francesca.pascalau.mapper.BillMapper;
import com.francesca.pascalau.mapper.ContractMapper;
import com.francesca.pascalau.model.BillDto;
import com.francesca.pascalau.model.ContractDto;
import com.francesca.pascalau.port.ContractServicePort;
import com.francesca.pascalau.repository.ContractRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class ContractRepositoryAdapter implements ContractServicePort {

    private final ContractRepository contractRepository;

    @Override
    public void create(ContractDto contractDto) {
        contractRepository.save(ContractMapper.INSTANCE.mapFromDto(contractDto));
    }

    @Override
    public List<BillDto> findAllBills(Long id) {
        return contractRepository.findById(id)
                .orElseThrow()
                .getBills()
                .stream()
                .map(BillMapper.INSTANCE::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ContractDto> findAllContractsWithBills(Pageable pageable) {
        return contractRepository.findByBillsExists(pageable)
                .stream()
                .map(ContractMapper.INSTANCE::mapToDto)
                .collect(Collectors.toList());
    }
}
