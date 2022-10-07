package com.testevr.miniautorizador.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CardCreateRequestDTO {

    @NotEmpty(message = "Campo número do cartão é obrigatório")
    @JsonProperty("numeroCartao")
    private String cardNumber;

    @NotEmpty(message = "Senha é obrigatório")
    @JsonProperty("senha")
    private String password;
}
