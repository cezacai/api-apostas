package com.cezacai.apiapostas.exceptions;

public class ApostaInvalidaException extends RuntimeException {
    public ApostaInvalidaException(String mensagem, Exception ex) {
        super(mensagem,ex);
    }
}
