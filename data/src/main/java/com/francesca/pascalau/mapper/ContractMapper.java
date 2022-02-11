package com.francesca.pascalau.mapper;

import com.francesca.pascalau.entities.Bill;
import com.francesca.pascalau.entities.Contract;
import com.francesca.pascalau.model.BillDto;
import com.francesca.pascalau.model.ContractDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ContractMapper {

    ContractMapper INSTANCE = Mappers.getMapper(ContractMapper.class);

    ContractDto mapToDto(Contract contract);

    Contract mapFromDto(ContractDto contractDto);

    Bill map(BillDto billDto);
}
