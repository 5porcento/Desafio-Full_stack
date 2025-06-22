package com.desafio.api.back.repository;

import com.desafio.api.back.entity.Heroi;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HeroiRepository  extends JpaRepository<Heroi, Integer> {
    Optional<Heroi> findByNome(String nome);
    Optional<Heroi> findByNomeHeroi(String nomeHeroi);
}
