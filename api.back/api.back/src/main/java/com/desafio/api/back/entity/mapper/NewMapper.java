package com.desafio.api.back.entity.mapper;

import com.desafio.api.back.entity.DTO.HeroiRequest;
import com.desafio.api.back.entity.DTO.HeroiResponse;
import com.desafio.api.back.entity.DTO.SuperpoderesResponse;
import com.desafio.api.back.entity.Heroi;
import com.desafio.api.back.entity.Superpoderes;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass

public class NewMapper {

    public static Heroi toHeroi(HeroiRequest dto, List<Superpoderes> superpoderes) {
        return Heroi.builder()
                .nome(dto.nome())
                .nomeHeroi(dto.nomeHeroi())
                .dataNascimento(dto.dataNascimento())
                .altura(dto.altura())
                .peso(dto.peso())
                .superpoderes(superpoderes)
                .build();
    }

    public static Heroi toHeroiUpdate(HeroiRequest dto) {
        return Heroi.builder()
                .nome(dto.nome())
                .nomeHeroi(dto.nomeHeroi())
                .dataNascimento(dto.dataNascimento())
                .altura(dto.altura())
                .peso(dto.peso())

                .build();
    }
    public static HeroiResponse toHeroiResponse(Heroi heroi) {

       List<SuperpoderesResponse> superpoderesResponses = heroi.getSuperpoderes()
               .stream()
               .map(superpoderes -> SuperPoderesMapper.toSuperpoderesResponse(superpoderes))
               .toList();


        return HeroiResponse.builder()
                .id(heroi.getId())
                .nome(heroi.getNome())
                .nomeHeroi(heroi.getNomeHeroi())
                .dataNascimento(heroi.getDataNascimento())
                .altura(heroi.getAltura())
                .peso(heroi.getPeso())
                .superpoderes(superpoderesResponses)
                .build();
    }
}
