package com.francesca.pascalau.mapper;

import com.francesca.pascalau.entities.Contract;
import com.francesca.pascalau.entities.Customer;
import com.francesca.pascalau.model.ContractDto;
import com.francesca.pascalau.model.CustomerDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ContractMapper {

    ContractMapper INSTANCE = Mappers.getMapper(ContractMapper.class);

    @Mapping(ignore = true, target = "bills")
    ContractDto mapToDto(Contract contract);

    @Mapping(ignore = true, target = "bills")
    Contract mapFromDto(ContractDto contractDto);

    Customer mapCustomer(CustomerDto customerDto);
}
