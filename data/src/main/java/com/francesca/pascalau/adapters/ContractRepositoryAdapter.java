package com.francesca.pascalau.adapters;

import com.francesca.pascalau.entities.LogRegistry;
import com.francesca.pascalau.mapper.BillMapper;
import com.francesca.pascalau.mapper.ContractMapper;
import com.francesca.pascalau.model.BillDto;
import com.francesca.pascalau.model.ContractDto;
import com.francesca.pascalau.port.ContractServicePort;
import com.francesca.pascalau.repository.ContractRepository;
import com.francesca.pascalau.repository.LogRegistryRepository;
import com.francesca.pascalau.request.ContractRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class ContractRepositoryAdapter implements ContractServicePort {

    private final ContractRepository contractRepository;
    private final LogRegistryRepository logRegistryRepository;

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
    public Page<ContractDto> findAllContractsWithBills(Pageable pageable) {
        return new PageImpl<>(contractRepository.findByBillsExists(pageable)
                .stream()
                .map(ContractMapper.INSTANCE::mapToDto)
                .collect(Collectors.toList())
        );
    }

    @Override
    public Page<ContractDto> findAll(ContractRequest request, Pageable pageable) {
        return new PageImpl<>(contractRepository.findAll(request, pageable)
                .stream()
                .map(ContractMapper.INSTANCE::mapToDto)
                .collect(Collectors.toList())
        );
    }

    @Override
    public List<ContractDto> findAllByCustomerId(Long customerId) {
        return contractRepository.findByCustomerId(customerId).stream()
                .map(ContractMapper.INSTANCE::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public ContractDto findById(Long contractId) {
        var contract = contractRepository.findById(contractId).orElseThrow(RuntimeException::new);
        contract.setDetails(contract.getDetails() + " World");

        return ContractMapper.INSTANCE.mapToDto(contract);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public ContractDto findByIdWithLogs(Long contractId) {
        saveLogRegistry("ContractRepositoryAdapter#findByIdWithLogs, start");

        var contract = contractRepository.findById(contractId).orElseThrow(RuntimeException::new);
        contract.setDetails(contract.getDetails() + " World");

        saveLogRegistry("ContractRepositoryAdapter#findByIdWithLogs, stop");

        return ContractMapper.INSTANCE.mapToDto(contract);
    }

    private void saveLogRegistry(final String methodName) {
        final LogRegistry logRegistry = new LogRegistry();
        logRegistry.setMethod(methodName);

        logRegistryRepository.save(logRegistry);
    }
}
