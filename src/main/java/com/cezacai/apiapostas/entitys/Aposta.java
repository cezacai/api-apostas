package com.cezacai.apiapostas.entitys;


import com.cezacai.apiapostas.entitys.enums.ResultadoEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tb_aposta")
public class Aposta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private UUID id;

    @NotBlank(message = "jogo não pode ser vazio")
    private String jogo;

    @NotBlank(message = "tipo não pode ser vazio")
    private String tipo;

    @NotNull(message = "resultado inválido")
    private ResultadoEnum resultado;

    @NotNull(message = "valor inválido")
    private Double valor;

    @NotNull(message = "valor ODD inválida")
    private Double odd;

    @NotNull(message = "data inválida")
    private LocalDate data;

    @ManyToOne
    @JoinColumn(name = "competicao_ID")
    private Competicao competicao;
}
