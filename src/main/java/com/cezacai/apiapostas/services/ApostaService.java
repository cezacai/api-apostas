package com.cezacai.apiapostas.services;

import com.cezacai.apiapostas.dtos.out.ApostaResponseDTO;
import com.cezacai.apiapostas.entity.Aposta;
import com.cezacai.apiapostas.entity.Competicao;
import com.cezacai.apiapostas.exception.ApostaInvalidaException;
import com.cezacai.apiapostas.exception.ApostaNaoEncontradaException;
import com.cezacai.apiapostas.services.repositories.ApostaRepository;
import com.cezacai.apiapostas.services.repositories.CompeticaoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ApostaService {

    private ApostaRepository apostaRepository;
    private CompeticaoRepository competicaoRepository;

    private ModelMapper modelMapper;


    public ApostaService(ApostaRepository apostaRepository, CompeticaoRepository competicaoRepository, ModelMapper modelMapper) {
        this.apostaRepository = apostaRepository;
        this.competicaoRepository = competicaoRepository;
        this.modelMapper = modelMapper;
    }

    public ApostaResponseDTO salvar(Aposta aposta){
        try{

            Optional<Competicao> opCompeticao = competicaoRepository.findByNome(aposta.getCompeticao().getNome());
            opCompeticao.ifPresent(aposta::setCompeticao);
            return entityToDto(apostaRepository.save(aposta));

        }catch (Exception ex){
            throw new ApostaInvalidaException("Erro ao gravar aposta",ex);
        }
    }

    private ApostaResponseDTO entityToDto(Aposta aposta){

        return this.modelMapper.map(aposta, ApostaResponseDTO.class );
    }

    public List<Aposta> listarTodas() {
        return apostaRepository.findAll();
    }

    public Aposta consultarPorId(UUID id) {
        return apostaRepository.findById(id)
                .orElseThrow(() -> new ApostaNaoEncontradaException("Aposta não encontrada"));
    }
}
