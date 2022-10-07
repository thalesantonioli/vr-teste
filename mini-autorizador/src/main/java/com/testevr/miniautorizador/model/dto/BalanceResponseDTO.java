package com.testevr.miniautorizador.model.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BalanceResponseDTO {
    private BigDecimal balance;
}
