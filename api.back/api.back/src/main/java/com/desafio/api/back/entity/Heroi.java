package com.desafio.api.back.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Herois")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Heroi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    @Column(unique = true)
    private String nomeHeroi;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "HeroisSuperpoderes", // Nome da tabela de junção conforme o diagrama
            joinColumns = @JoinColumn(name = "heroi_id",referencedColumnName = "id"), // Coluna que referencia o Heroi (conforme diagrama)
            inverseJoinColumns = @JoinColumn(name = "superpoder_id",referencedColumnName = "id") // Coluna que referencia o Superpoder (conforme diagrama)
    )
    private List<Superpoderes> superpoderes;

    private LocalDate dataNascimento;
    private float altura;
    private float peso;
}
