package com.cezacai.apiapostas.entitys.enums;

import lombok.Getter;

@Getter
public enum ResultadoEnum {
    GREEN("vitória"),
    RED("derrota"),
    WHITE("empate");

    private String descricao;

    ResultadoEnum(String descricao) {
    }


}
