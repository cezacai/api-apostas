package com.cezacai.apiapostas.services.repositories;

import com.cezacai.apiapostas.entitys.Aposta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ApostaRepository extends JpaRepository<Aposta, UUID> {
}
