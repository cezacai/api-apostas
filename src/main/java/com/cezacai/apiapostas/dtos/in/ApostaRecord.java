package com.cezacai.apiapostas.dtos.in;

import com.cezacai.apiapostas.entitys.Competicao;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record ApostaRecord(
        @NotBlank(message = "jogo inválido") String jogo,
        @NotBlank(message = "tipo inválido") String tipo,
        @NotBlank(message = "resultado inválido") String resultado,
        @NotNull (message = "valor inválido") Double valor,
        @NotNull (message = "odd inválida")Double odd,
        @NotNull (message = "data inválida")LocalDate data,
        CompeticaoRecord competicao) {
}
