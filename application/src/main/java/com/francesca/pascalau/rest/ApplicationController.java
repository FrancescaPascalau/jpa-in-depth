package com.francesca.pascalau.rest;

import com.francesca.pascalau.entities.Contract;
import com.francesca.pascalau.model.BillDto;
import com.francesca.pascalau.model.ContractDto;
import com.francesca.pascalau.services.BillService;
import com.francesca.pascalau.services.ContractService;
import com.francesca.pascalau.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping
    public ResponseEntity<List<ContractDto>> getAllContracts(@RequestParam(defaultValue = "0") Integer pageNo,
                                                             @RequestParam(defaultValue = "2") Integer pageSize) {
        List<ContractDto> contracts = contractService.findAllWithBills(pageNo, pageSize);

        return new ResponseEntity<>(contracts, new HttpHeaders(), HttpStatus.OK);
    }
}
