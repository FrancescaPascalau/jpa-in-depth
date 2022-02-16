package com.francesca.pascalau.port;

import com.francesca.pascalau.model.BillDto;

public interface BillServicePort {

    BillDto save(BillDto bill);

    BillDto findBill(Long billId);

    void create(BillDto billDto);

    BillDto addAmount(Long billId, Long amount);
}
