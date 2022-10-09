package com.testevr.miniautorizador.service;

import com.testevr.miniautorizador.exception.NotFoundException;
import com.testevr.miniautorizador.exception.UnprocessableEntityException;
import com.testevr.miniautorizador.model.dto.CardCreateRequestDTO;
import com.testevr.miniautorizador.model.entity.Card;

public interface CardService {
    Card create(CardCreateRequestDTO cardCreateRequestDTO) throws UnprocessableEntityException;
    Card findByCardNumber(String cardNumber) throws NotFoundException;
}
