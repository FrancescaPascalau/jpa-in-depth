package com.francesca.pascalau.mapper;

import com.francesca.pascalau.entities.Customer;
import com.francesca.pascalau.model.CustomerDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    CustomerDto mapToDto(Customer customer);

    Customer mapFromDto(CustomerDto customerDto);
}
