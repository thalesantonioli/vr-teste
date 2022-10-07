package com.testevr.miniautorizador.mapper;

import com.testevr.miniautorizador.model.dto.CardCreateRequestDTO;
import com.testevr.miniautorizador.model.dto.CardResponseCreateDTO;
import com.testevr.miniautorizador.model.entity.Card;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CardMapper {
    Card cardCreateRequestDTOToCard(CardCreateRequestDTO cardCreateRequestDTO);
    CardResponseCreateDTO cardToCardResponseCreateDTO(Card card);
}
