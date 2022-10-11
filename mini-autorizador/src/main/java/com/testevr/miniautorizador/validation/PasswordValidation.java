package com.testevr.miniautorizador.validation;

import com.testevr.miniautorizador.exception.UnprocessableEntityException;
import com.testevr.miniautorizador.model.dto.BalanceDepositRequestDTO;
import com.testevr.miniautorizador.model.entity.Balance;
import com.testevr.miniautorizador.model.enums.ErrorMessage;

public class PasswordValidation extends TransactionValidation {

    private final ErrorMessage errorMessage = ErrorMessage.INVALID_PASSWORD;
    @Override
    public Boolean isValid(Balance balance, BalanceDepositRequestDTO balanceDepositRequestDTO) throws UnprocessableEntityException {
        return balance != null && balance.getCard() != null && balance.getCard().getPassword() != null
                && balance.getCard().getPassword().equals(balanceDepositRequestDTO.getPassword());
    }

    @Override
    public ErrorMessage getErrorMessage() {
        return errorMessage;
    }
}
