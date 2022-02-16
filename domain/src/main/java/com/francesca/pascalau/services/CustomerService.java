package com.francesca.pascalau.services;

import com.francesca.pascalau.model.CustomerDto;
import com.francesca.pascalau.port.CustomerServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerServicePort customerService;

    public CustomerDto createCustomer() {
        var customer = CustomerDto.builder()
                .id(1L)
                .firstName("Francesca")
                .lastName("Pascalau")
                .build();

        customerService.create(customer);

        return customer;
    }

    public void delete(Long customerId) {
        customerService.delete(customerId);
    }
}
