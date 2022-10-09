package com.testevr.miniautorizador.controller;

import com.testevr.miniautorizador.exception.NotFoundException;
import com.testevr.miniautorizador.exception.UnprocessableEntityException;
import com.testevr.miniautorizador.mapper.BalanceMapper;
import com.testevr.miniautorizador.mapper.CardMapper;
import com.testevr.miniautorizador.model.dto.BalanceResponseDTO;
import com.testevr.miniautorizador.model.dto.CardCreateRequestDTO;
import com.testevr.miniautorizador.model.dto.CardResponseCreateDTO;
import com.testevr.miniautorizador.model.entity.Card;
import com.testevr.miniautorizador.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("cartoes")
public class CardController {

    @Autowired
    private CardService cardService;

    @Autowired
    private CardMapper cardMapper;

    @Autowired
    private BalanceMapper balanceMapper;

    @PostMapping
    public ResponseEntity<CardResponseCreateDTO> create(@RequestBody @Valid CardCreateRequestDTO cardCreateRequestDTO) throws UnprocessableEntityException {
        Card card = cardService.create(cardCreateRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(cardMapper.cardToCardResponseCreateDTO(card));
    }

    @GetMapping("{cardNumber}")
    public ResponseEntity<BalanceResponseDTO> getBalance(@PathVariable("cardNumber") String cardNumber) throws NotFoundException {
        Card card = cardService.findByCardNumber(cardNumber);
        return ResponseEntity.status(HttpStatus.OK).body(balanceMapper.balanceToBalanceResponseDTO(card.getBalance()));
    }
}
