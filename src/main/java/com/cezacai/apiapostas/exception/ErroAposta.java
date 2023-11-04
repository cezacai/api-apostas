package com.cezacai.apiapostas.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
public class ErroAposta {

    private LocalDateTime data;
    private int codigo;
    private String mensagem;
}
