package com.cezacai.apiapostas.dtos.out;

import com.cezacai.apiapostas.entitys.Aposta;
import com.cezacai.apiapostas.entitys.enums.ResultadoEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    public ApostaResponseDTO entityToDto(Aposta aposta){
        ApostaResponseDTO apostaResponseDTO = new ApostaResponseDTO(
            this.id = aposta.getId(),
            this.data = aposta.getData(),
            this.valor = aposta.getValor(),
            this.odd = aposta.getOdd(),
                this.resultado = aposta.getResultado().getDescricao()
        );
        return apostaResponseDTO;
    }
}
