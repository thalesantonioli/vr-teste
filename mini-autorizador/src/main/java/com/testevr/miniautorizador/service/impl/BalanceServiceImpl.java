package com.testevr.miniautorizador.service.impl;

import com.testevr.miniautorizador.service.BalanceService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class BalanceServiceImpl implements BalanceService {

    private final BigDecimal OPENING_BALANCE = BigDecimal.valueOf(500);

    @Override
    public BigDecimal getOpeningBalance() {
        return OPENING_BALANCE;
    }
}
