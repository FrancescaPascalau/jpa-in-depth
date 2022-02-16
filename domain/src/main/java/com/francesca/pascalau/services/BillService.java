package com.francesca.pascalau.services;

import com.francesca.pascalau.model.BillDto;
import com.francesca.pascalau.model.BillDto.Type;
import com.francesca.pascalau.model.ContractDto;
import com.francesca.pascalau.port.BillServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BillService {

    private final BillServicePort billService;

    public void addBill(ContractDto contract, Type type, long amount) {
        billService.create(BillDto.builder()
                .amount(amount)
                .type(type)
                .contract(contract)
                .build());
    }

    public BillDto updateAmount(Long billId, Long amount) {
        var bill = billService.addAmount(billId, amount);

        sleep(2000);

        return bill;
    }

    public BillDto addAmount(Long billId, Long amount) {
        var bill = billService.findBill(billId);
        bill.setAmount(bill.getAmount() + amount);

        sleep(3000);

        return billService.save(bill);
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
