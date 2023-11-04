package com.cezacai.apiapostas.exception;

public class ApostaInvalidaException extends RuntimeException {
    public ApostaInvalidaException(String mensagem, Exception ex) {
        super(mensagem,ex);
    }
}
