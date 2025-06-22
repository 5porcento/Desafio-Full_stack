package com.desafio.api.back.entity.DTO;

import lombok.Builder;

import java.util.List;

@Builder
public record SuperpoderesResponse(Integer id,String superpoder, String descricao) {
}
