package com.testevr.miniautorizador.validation;

import com.testevr.miniautorizador.model.dto.BalanceDepositRequestDTO;
import com.testevr.miniautorizador.model.entity.Balance;
import com.testevr.miniautorizador.model.enums.ErrorMessage;

public class BalanceValidation extends TransactionValidation {

    private final ErrorMessage errorMessage = ErrorMessage.INSUFFICIENT_FUNDS;

    @Override
    public Boolean isValid(Balance balance, BalanceDepositRequestDTO balanceDepositRequestDTO) {
        return balance != null && balance.getBalance() != null
                && balance.getBalance().compareTo(balanceDepositRequestDTO.getValue()) >= 0;
    }

    @Override
    public ErrorMessage getErrorMessage() {
        return errorMessage;
    }
}
