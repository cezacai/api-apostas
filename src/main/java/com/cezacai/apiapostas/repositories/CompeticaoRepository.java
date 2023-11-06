package com.cezacai.apiapostas.repositories;

import com.cezacai.apiapostas.domain.Competicao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompeticaoRepository extends JpaRepository<Competicao,Long> {
    Optional<Competicao> findByNome(String nome);
}
