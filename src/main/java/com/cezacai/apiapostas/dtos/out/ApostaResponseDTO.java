package com.cezacai.apiapostas.dtos.out;

import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApostaResponseDTO {
    private UUID id;
    private LocalDate data;
    private Double valor;
    private Double odd;
    private String resultado;
}
