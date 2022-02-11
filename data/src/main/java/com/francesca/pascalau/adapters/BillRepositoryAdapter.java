package com.francesca.pascalau.adapters;

import com.francesca.pascalau.repository.BillRepository;
import com.francesca.pascalau.mapper.BillMapper;
import com.francesca.pascalau.model.BillDto;
import com.francesca.pascalau.port.BillServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class BillRepositoryAdapter implements BillServicePort {

    private final BillRepository billRepository;

    @Override
    public void create(BillDto billDto) {
        billRepository.save(BillMapper.INSTANCE.mapFromDto(billDto));
    }
}
