package com.testevr.miniautorizador.mapper;

import com.testevr.miniautorizador.model.dto.BalanceResponseDTO;
import com.testevr.miniautorizador.model.entity.Balance;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BalanceMapper {
    BalanceResponseDTO balanceToBalanceResponseDTO(Balance balance);
}
