package com.testevr.miniautorizador.service.impl;

import com.testevr.miniautorizador.exception.NotFoundException;
import com.testevr.miniautorizador.mapper.CardMapper;
import com.testevr.miniautorizador.model.dto.CardCreateRequestDTO;
import com.testevr.miniautorizador.model.entity.Balance;
import com.testevr.miniautorizador.model.entity.Card;
import com.testevr.miniautorizador.repository.CardRepository;
import com.testevr.miniautorizador.service.BalanceService;
import com.testevr.miniautorizador.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardServiceImpl implements CardService {

    @Autowired
    private BalanceService balanceService;

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private CardMapper cardMapper;

    @Override
    public Card create(CardCreateRequestDTO cardCreateRequestDTO) {
        Card card = cardMapper.cardCreateRequestDTOToCard(cardCreateRequestDTO);
        Balance balance = Balance.builder()
                .balance(balanceService.getOpeningBalance())
                .build();
        card.setBalance(balance);
        return cardRepository.save(card);
    }
    @Override
    public Card findByCardNumber(String cardNumber) throws NotFoundException {
        return cardRepository.findByCardNumber(cardNumber).orElseThrow(NotFoundException::new);
    }
}
