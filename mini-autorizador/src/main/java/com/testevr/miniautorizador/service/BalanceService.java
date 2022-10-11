package com.testevr.miniautorizador.service;

import com.testevr.miniautorizador.exception.UnprocessableEntityException;
import com.testevr.miniautorizador.model.dto.BalanceDepositRequestDTO;
import com.testevr.miniautorizador.model.entity.Balance;

import java.math.BigDecimal;

public interface BalanceService {
    BigDecimal getOpeningBalance();
    Balance transact(BalanceDepositRequestDTO balanceDepositRequestDTO) throws UnprocessableEntityException;
    Balance findByCardNumber(String cardNumber);
}
