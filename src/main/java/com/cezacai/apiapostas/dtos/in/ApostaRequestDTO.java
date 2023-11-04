package com.cezacai.apiapostas.dtos.in;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApostaRequestDTO {

    @NotBlank(message = "jogo não pode ser nulo")
    private String jogo;
    @NotBlank(message = "tipo não pode ser nulo")
    private String tipo;
    @NotBlank(message = "resultado não pode ser nulo")
    private String resultado;
    @NotNull(message = "valor não pode ser nulo")
    private Double valor;
    @NotNull(message = "odd não pode ser nulo")
    private Double odd;
    @NotNull(message = "data não pode ser nulo")
    private LocalDate data;
    @NotNull(message = "competicao não pode ser nulo")
    private CompeticaoDTO competicao;

}