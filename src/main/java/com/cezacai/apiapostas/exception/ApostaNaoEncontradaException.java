package com.cezacai.apiapostas.exception;

import java.util.UUID;

public class ApostaNaoEncontradaException extends RuntimeException {
    public ApostaNaoEncontradaException(String mensagem) {
        super(mensagem);
    }
}
