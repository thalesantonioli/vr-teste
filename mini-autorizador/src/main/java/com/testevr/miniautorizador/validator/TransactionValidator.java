package com.testevr.miniautorizador.validator;

import com.testevr.miniautorizador.exception.UnprocessableEntityException;
import com.testevr.miniautorizador.model.dto.BalanceDepositRequestDTO;
import com.testevr.miniautorizador.model.entity.Balance;
import com.testevr.miniautorizador.validation.BalanceValidation;
import com.testevr.miniautorizador.validation.CardValidation;
import com.testevr.miniautorizador.validation.PasswordValidation;
import com.testevr.miniautorizador.validation.TransactionValidation;

import java.util.ArrayList;
import java.util.List;
public class TransactionValidator {

    private List<TransactionValidation> fieldValidations = new ArrayList<>();

    public TransactionValidator(){
        fieldValidations.add(new CardValidation());
        fieldValidations.add(new PasswordValidation());
        fieldValidations.add(new BalanceValidation());
    }

    public Boolean validate(Balance balance, BalanceDepositRequestDTO balanceDepositRequestDTO) throws UnprocessableEntityException {
        Boolean isValid;
        for(TransactionValidation transactionValidator : fieldValidations){
            isValid = transactionValidator.isValid(balance, balanceDepositRequestDTO);
            if(!isValid){
                throw new UnprocessableEntityException(transactionValidator.getErrorMessage());
            }
        }
        return Boolean.TRUE;
    }
}
