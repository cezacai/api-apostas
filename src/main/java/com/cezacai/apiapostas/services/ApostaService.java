package com.cezacai.apiapostas.services;

import com.cezacai.apiapostas.dtos.out.ApostaResponseDTO;
import com.cezacai.apiapostas.entitys.Aposta;
import com.cezacai.apiapostas.exceptions.ApostaInvalidaException;
import com.cezacai.apiapostas.services.repositories.ApostaRepository;
import org.springframework.stereotype.Service;

@Service
public class ApostaService {

    private ApostaRepository apostaRepository;


    public ApostaService(ApostaRepository apostaRepository) {
        this.apostaRepository = apostaRepository;
    }

    public ApostaResponseDTO salvar(Aposta aposta){
        try{
            ApostaResponseDTO responseDTO = new ApostaResponseDTO();
            return responseDTO.entityToDto(apostaRepository.save(aposta));

        }catch (Exception ex){
            throw new ApostaInvalidaException("Erro ao gravar aposta",ex);
        }
    }
}
