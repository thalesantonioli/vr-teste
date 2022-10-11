package com.testevr.miniautorizador.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BalanceDepositRequestDTO {

    @JsonProperty("numeroCartao")
    private String cardNumber;

    @JsonProperty("senha")
    private String password;

    @JsonProperty("valor")
    private BigDecimal value;
}
