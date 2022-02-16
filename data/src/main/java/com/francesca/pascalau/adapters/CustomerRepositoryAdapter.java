package com.francesca.pascalau.adapters;

import com.francesca.pascalau.mapper.CustomerMapper;
import com.francesca.pascalau.model.CustomerDto;
import com.francesca.pascalau.port.CustomerServicePort;
import com.francesca.pascalau.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CustomerRepositoryAdapter implements CustomerServicePort {

    private final CustomerRepository customerRepository;

    @Override
    public void create(CustomerDto customerDto) {
        customerRepository.save(CustomerMapper.INSTANCE.mapFromDto(customerDto));
    }

    @Override
    public void delete(Long customerId) {
        var customer = customerRepository.findById(customerId);

        if (customer.isPresent())
            customerRepository.deleteById(customerId);
    }
}
