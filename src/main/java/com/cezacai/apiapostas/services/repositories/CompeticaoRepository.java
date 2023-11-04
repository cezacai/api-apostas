package com.cezacai.apiapostas.services.repositories;

import com.cezacai.apiapostas.entity.Competicao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompeticaoRepository extends JpaRepository<Competicao,Long> {
    Optional<Competicao> findByNome(String nome);
}
