package com.testevr.miniautorizador.validation;

import com.testevr.miniautorizador.model.dto.BalanceDepositRequestDTO;
import com.testevr.miniautorizador.model.entity.Balance;
import com.testevr.miniautorizador.model.enums.ErrorMessage;

public abstract class TransactionValidation {
    public abstract Boolean isValid(Balance balance, BalanceDepositRequestDTO balanceDepositRequestDTO);
    public abstract ErrorMessage getErrorMessage();
}
