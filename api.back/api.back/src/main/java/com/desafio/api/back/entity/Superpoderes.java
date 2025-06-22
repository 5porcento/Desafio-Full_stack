package com.desafio.api.back.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Table(name = "Superpoderes")
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Superpoderes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String superpoder;
    private String descricao;

    @ManyToMany(mappedBy = "superpoderes")
    @JsonIgnore
    private List<Heroi> herois;
}
