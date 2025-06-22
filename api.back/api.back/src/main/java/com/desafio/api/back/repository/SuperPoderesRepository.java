package com.desafio.api.back.repository;

import com.desafio.api.back.entity.Superpoderes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SuperPoderesRepository extends JpaRepository <Superpoderes, Integer> {
}
