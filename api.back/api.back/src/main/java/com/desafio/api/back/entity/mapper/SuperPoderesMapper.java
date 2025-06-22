package com.desafio.api.back.entity.mapper;

import com.desafio.api.back.entity.DTO.SuperpoderesRequest;
import com.desafio.api.back.entity.DTO.SuperpoderesResponse;
import com.desafio.api.back.entity.Superpoderes;
import lombok.experimental.UtilityClass;

@UtilityClass
public class SuperPoderesMapper {

    public static Superpoderes toSuperpoderes(SuperpoderesRequest superpoderesRequest) {
        return Superpoderes.builder()
                .id(superpoderesRequest.id())
                .superpoder(superpoderesRequest.superpoder())
                .descricao(superpoderesRequest.descricao())
                .build();
    }

    public static SuperpoderesResponse toSuperpoderesResponse(Superpoderes superpoderes) {
        return SuperpoderesResponse.builder()
                .id(superpoderes.getId())
                .descricao(superpoderes.getDescricao())
                .superpoder(superpoderes.getSuperpoder())
                .build();
    }
}
