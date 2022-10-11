package com.testevr.miniautorizador.service.impl;

import com.testevr.miniautorizador.exception.UnprocessableEntityException;
import com.testevr.miniautorizador.model.dto.BalanceDepositRequestDTO;
import com.testevr.miniautorizador.model.entity.Balance;
import com.testevr.miniautorizador.model.enums.ErrorMessage;
import com.testevr.miniautorizador.repository.BalanceRepository;
import com.testevr.miniautorizador.service.BalanceService;
import com.testevr.miniautorizador.validator.TransactionValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.ConcurrencyFailureException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class BalanceServiceImpl implements BalanceService {

    private final BigDecimal OPENING_BALANCE = BigDecimal.valueOf(500);

    private final Integer MAXIMUM_ATTEMPTS = 3;

    @Autowired
    private BalanceRepository balanceRepository;

    private TransactionValidator transactionValidator;

    public BalanceServiceImpl(){
        this.transactionValidator = new TransactionValidator();
    }

    @Override
    public BigDecimal getOpeningBalance() {
        return OPENING_BALANCE;
    }

    @Override
    public Balance transact(BalanceDepositRequestDTO balanceDepositRequestDTO) throws UnprocessableEntityException {
        Integer attempts = 0;
        Balance balance = null;
        do {
            try {
                balance = findByCardNumber(balanceDepositRequestDTO.getCardNumber());
                transactionValidator.validate(balance, balanceDepositRequestDTO);
                balance.setBalance(balance.getBalance().subtract(balanceDepositRequestDTO.getValue()));
                return balanceRepository.save(balance);
            } catch (ConcurrencyFailureException exception){
                attempts++;
                if(attempts.compareTo(MAXIMUM_ATTEMPTS) == 0){
                    throw new UnprocessableEntityException(ErrorMessage.MAX_MAXIMUM_ATTEMPTS.getMessage());
                }
            }
        } while (attempts < MAXIMUM_ATTEMPTS);
        return balance;
    }

    @Override
    public Balance findByCardNumber(String cardNumber) {
        return balanceRepository.findByCardCardNumber(cardNumber);
    }
}
