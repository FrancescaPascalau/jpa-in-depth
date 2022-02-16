package com.francesca.pascalau.rest;

import com.francesca.pascalau.model.*;
import com.francesca.pascalau.request.ContractRequest;
import com.francesca.pascalau.services.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
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

    @PostMapping("/create/bills")
    public void createBills() {
        var contract = contractService.createContract(customerService.createCustomer());

        billService.addBill(contract, BillDto.Type.ELECTRICITY, 100L);
        billService.addBill(contract, BillDto.Type.GAS, 80L);
        billService.addBill(contract, BillDto.Type.WATER, 35L);
    }

    @GetMapping("/find/bills")
    public List<BillDto> findAllBills() {
        return contractService.findAllBills(1L);
    }

    @GetMapping("/find/contracts")
    public ResponseEntity<Page<ContractDto>> getAllContracts(@RequestParam(defaultValue = "0") Integer pageNumber,
                                                             @RequestParam(defaultValue = "10") Integer pageSize) {
        Page<ContractDto> contracts = contractService.findAllContracts(pageNumber, pageSize);

        return new ResponseEntity<>(contracts, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/find/contracts/id")
    public ResponseEntity<List<ContractDto>> getAllContracts(@RequestParam Long customerId) {
        List<ContractDto> contracts = contractService.findByCustomerId(customerId);

        return new ResponseEntity<>(contracts, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/find/contract/id")
    public ResponseEntity<ContractDto> getContract(@RequestParam Long contractId) {
        ContractDto contract = contractService.findByContractId(contractId);

        return new ResponseEntity<>(contract, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/find")
    public Page<ContractDto> findContracts(final ContractRequest request) {
        return contractService.find(request);
    }

    @DeleteMapping("/delete/customer")
    public ResponseEntity<List<ContractDto>> deleteCustomer(@RequestParam Long customerId) {
        customerService.delete(customerId);

        return new ResponseEntity<>(new HttpHeaders(), HttpStatus.OK);
    }

    @PutMapping("/update/amount")
    public ResponseEntity<BillDto> updateAmountToBill(@RequestParam Long billId,
                                                      @RequestParam Long amount) {
        var bill = billService.updateAmount(billId, amount);

        return new ResponseEntity<>(bill, new HttpHeaders(), HttpStatus.OK);
    }

    @PutMapping("/add/amount")
    public ResponseEntity<BillDto> addAmountToBill(@RequestParam Long billId,
                                                   @RequestParam Long amount) {
        var bill = billService.addAmount(billId, amount);

        return new ResponseEntity<>(bill, new HttpHeaders(), HttpStatus.OK);
    }
}
