package com.testevr.miniautorizador.validation;

import com.testevr.miniautorizador.model.dto.BalanceDepositRequestDTO;
import com.testevr.miniautorizador.model.entity.Balance;
import com.testevr.miniautorizador.model.enums.ErrorMessage;

public class CardValidation extends TransactionValidation {

    private final ErrorMessage errorMessage = ErrorMessage.CARD_NON_EXISTENT;
    @Override
    public Boolean isValid(Balance balance, BalanceDepositRequestDTO balanceDepositRequestDTO) {
        return balance != null && balance.getCard() != null
                && balance.getCard().getCardNumber().equals(balanceDepositRequestDTO.getCardNumber());
    }

    @Override
    public ErrorMessage getErrorMessage() {
        return errorMessage;
    }
}
