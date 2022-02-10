package com.francesca.pascalau.rest;

import com.francesca.pascalau.services.CustomerService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("jpa/v1")
public class ApplicationController {

    private CustomerService customerService;

    @PostMapping("/customer/create")
    public void createCustomer() {
    }
}
