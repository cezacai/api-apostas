package com.cezacai.apiapostas.controller;

import com.cezacai.apiapostas.dtos.in.ApostaRequestDTO;
import com.cezacai.apiapostas.dtos.out.ApostaResponseDTO;
import com.cezacai.apiapostas.entity.Aposta;
import com.cezacai.apiapostas.services.ApostaService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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
    public ResponseEntity<ApostaResponseDTO> salvar(@RequestBody @Valid ApostaRequestDTO apostaRequestDTO){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(apostaService.salvar(dtoToEntity(apostaRequestDTO)));
    }

    @GetMapping
    public ResponseEntity<List<Aposta>> consultarTodas(){
        return ResponseEntity.status(HttpStatus.OK).body(apostaService.listarTodas());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Aposta> consultarPorId(@PathVariable @Valid UUID id){
        return ResponseEntity.status(HttpStatus.OK).body(apostaService.consultarPorId(id));


    }

    private Aposta dtoToEntity(ApostaRequestDTO apReq){
        return modelMapper.map(apReq,Aposta.class);
    }
}
