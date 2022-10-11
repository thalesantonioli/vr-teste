package com.testevr.miniautorizador.model.enums;

public enum ErrorMessage {
    MAX_MAXIMUM_ATTEMPTS("TENTATIVAS_EXCEDIDAS"),
    CARD_NON_EXISTENT("CARTAO_INEXISTENTE"),
    INVALID_PASSWORD("SENHA_INVALIDA"),
    INSUFFICIENT_FUNDS("SALDO_INSUFICIENTE");

    private String message;

    ErrorMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }
}
