package com.francesca.pascalau.rest;

import com.francesca.pascalau.model.BillDto;
import com.francesca.pascalau.services.BillService;
import com.francesca.pascalau.services.ContractService;
import com.francesca.pascalau.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("jpa/v1")
@RequiredArgsConstructor
public class ApplicationController {

    private final CustomerService customerService;
    private final ContractService contractService;
    private final BillService billService;

    @PostMapping("/create")
    public void createAll() {
        var contract = contractService.createContract(customerService.createCustomer());

        billService.addBill(contract, BillDto.Type.ELECTRICITY, 100L);
        billService.addBill(contract, BillDto.Type.GAS, 80L);
        billService.addBill(contract, BillDto.Type.WATER, 35L);
    }

    @GetMapping("/find/bills")
    public List<BillDto> findAllBills() {
        return contractService.findAllBills(1L);
    }
}
