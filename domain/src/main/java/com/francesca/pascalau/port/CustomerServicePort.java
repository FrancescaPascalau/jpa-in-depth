package com.francesca.pascalau.port;

import com.francesca.pascalau.model.CustomerDto;

public interface CustomerServicePort {

    void create(CustomerDto customerDto);
}
