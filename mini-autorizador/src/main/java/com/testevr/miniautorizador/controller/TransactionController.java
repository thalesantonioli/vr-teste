package com.testevr.miniautorizador.controller;

import com.testevr.miniautorizador.exception.UnprocessableEntityException;
import com.testevr.miniautorizador.model.dto.BalanceDepositRequestDTO;
import com.testevr.miniautorizador.service.BalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("transacoes")
public class TransactionController {

    @Autowired
    private BalanceService balanceService;

    @PostMapping
    public ResponseEntity<String> transact(@RequestBody BalanceDepositRequestDTO balanceDepositRequestDTO) throws UnprocessableEntityException {
        balanceService.transact(balanceDepositRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
