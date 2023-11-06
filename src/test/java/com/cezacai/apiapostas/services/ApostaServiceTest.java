package com.cezacai.apiapostas.services;

import com.cezacai.apiapostas.domain.Aposta;
import com.cezacai.apiapostas.domain.Competicao;
import com.cezacai.apiapostas.dtos.out.ApostaResponseDTO;
import com.cezacai.apiapostas.repositories.ApostaRepository;
import com.cezacai.apiapostas.repositories.CompeticaoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.modelmapper.ModelMapper;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ApostaServiceTest {

    private ApostaService apostaService;
    private ApostaRepository apostaRepository;
    private CompeticaoRepository competicaoRepository;
    private ModelMapper modelMapper;

    @BeforeEach
    void setUp() {
        apostaRepository = mock(ApostaRepository.class);
        competicaoRepository = mock(CompeticaoRepository.class);
        modelMapper = mock(ModelMapper.class);
        apostaService = new ApostaService(apostaRepository, competicaoRepository, modelMapper);
    }

    @Test
    void salvarApostaSuccess() {
        Competicao competicao = new Competicao();
        competicao.setNome("Campeonato Brasileiro");
        competicao.setPais("Brasil");

        Aposta aposta = new Aposta();
        aposta.setCompeticao(competicao);
        aposta.setData(LocalDate.now());
        aposta.setJogo("Corinthians x Palmeiras");
        aposta.setOdd(2.0);
        aposta.setResultado("GREEN");
        aposta.setValor(10.0);

        when(competicaoRepository.findByNome(any())).thenReturn(Optional.of(competicao));
        when(apostaRepository.save(aposta)).thenReturn(aposta);
        when(modelMapper.map(aposta, ApostaResponseDTO.class)).thenReturn(new ApostaResponseDTO());

        ApostaResponseDTO result = apostaService.salvar(aposta);

        assertNotNull(result);
        verify(competicaoRepository, times(1)).findByNome("Campeonato Brasileiro");
        verify(apostaRepository, times(1)).save(aposta);
    }

    @Test
    void listarTodas() {
        List<Aposta> expectedApostas = Collections.singletonList(new Aposta());
        when(apostaRepository.findAll()).thenReturn(expectedApostas);

        List<Aposta> result = apostaService.listarTodas();

        assertEquals(expectedApostas, result);
        verify(apostaRepository, times(1)).findAll();
    }

    @Test
    void consultarPorId() {
        Competicao competicao = new Competicao(1L,
                "Campeonato Brasileiro",
                "Brasil");

        Aposta aposta = new Aposta(
                UUID.fromString("2340e36c-0a0b-4267-8a60-a772ea606465"),
                "Corinthians x Palmeiras",
                "gols",
                "GREEN",
                20.0,
                2.0,
                LocalDate.now(),competicao);

        when(apostaRepository.findById(any())).thenReturn(Optional.of(aposta));

        Aposta result = apostaService.consultarPorId(UUID.fromString("2340e36c-0a0b-4267-8a60-a772ea606465"));
        assertEquals(result, aposta);
        verify(apostaRepository,times(1)).findById(UUID.fromString("2340e36c-0a0b-4267-8a60-a772ea606465"));

    }
}