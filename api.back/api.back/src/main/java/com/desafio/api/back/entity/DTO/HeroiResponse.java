package com.desafio.api.back.entity.DTO;

import lombok.Builder;

import java.time.LocalDate;
import java.util.List;

@Builder
public record HeroiResponse(Integer id,
                            String nome,
                            String nomeHeroi,
                            LocalDate dataNascimento,
                            float altura,
                            float peso,
                            List<SuperpoderesResponse> superpoderes) {
}
