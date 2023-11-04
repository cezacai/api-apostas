package com.cezacai.apiapostas.dtos.in;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CompeticaoDTO {
    @NotBlank(message = "nome competição inválido")
    private String nome;
    @NotBlank(message = "país inválido")
    private String pais;
}
