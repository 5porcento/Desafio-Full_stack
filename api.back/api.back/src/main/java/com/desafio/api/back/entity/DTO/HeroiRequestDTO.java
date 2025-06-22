package com.desafio.api.back.entity.DTO;

import com.desafio.api.back.entity.Superpoderes;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class HeroiRequestDTO {
        private Integer id;
        private String nome;
        private String nomeHeroi;
        private List<Integer> superpoderesid;
        private LocalDate dataNascimento;
        private float altura;
        private float peso;
}
