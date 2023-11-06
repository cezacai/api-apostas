package com.cezacai.apiapostas.repositories;

import com.cezacai.apiapostas.domain.Aposta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ApostaRepository extends JpaRepository<Aposta, UUID> {

}
