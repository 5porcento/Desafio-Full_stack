package com.desafio.api.back.entity.DTO;

import lombok.Builder;

import java.time.LocalDate;
import java.util.List;

@Builder
public record HeroiRequest( Integer id,
String nome,
String nomeHeroi,
List<Integer>superpoderes,
LocalDate dataNascimento,
float altura,
float peso) {
}
