package com.cezacai.apiapostas.controllers;

import com.cezacai.apiapostas.dtos.in.ApostaRecord;
import com.cezacai.apiapostas.dtos.out.ApostaResponseDTO;
import com.cezacai.apiapostas.entitys.Aposta;
import com.cezacai.apiapostas.services.ApostaService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/apostas")
public class ApostaController {

    private ApostaService apostaService;
    private ModelMapper modelMapper;

    public ApostaController(ApostaService apostaService, ModelMapper modelMapper) {
        this.apostaService = apostaService;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    public ResponseEntity<ApostaResponseDTO> salvar(@RequestBody @Valid ApostaRecord apostaRecord){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(apostaService.salvar(recordToEntity(apostaRecord)));
    }

    public Aposta recordToEntity(ApostaRecord apRec){
        return modelMapper.map(apRec,Aposta.class);
    }
}
