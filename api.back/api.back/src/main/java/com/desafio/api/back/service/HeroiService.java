package com.desafio.api.back.service;

import com.desafio.api.back.entity.Heroi;
import com.desafio.api.back.entity.Superpoderes;
import com.desafio.api.back.entity.DTO.HeroiRequest;
import com.desafio.api.back.entity.mapper.NewMapper;
import com.desafio.api.back.repository.HeroiRepository;
import com.desafio.api.back.repository.SuperPoderesRepository;
import jakarta.transaction.Transactional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HeroiService {

    private final HeroiRepository heroiRepository;
    private final SuperPoderesRepository superPoderesRepository;

    public HeroiService(HeroiRepository heroiRepository, SuperPoderesRepository superPoderesRepository) {
        this.heroiRepository = heroiRepository;
        this.superPoderesRepository = superPoderesRepository;
    }

    public List<Heroi> listarTodosHerois() {
        return heroiRepository.findAll();
    }

    public Heroi salvarHeroi(HeroiRequest dto) {
        List<Superpoderes> superpoderes = superPoderesRepository.findAllById(dto.superpoderes());

        Heroi heroi = NewMapper.toHeroi(dto, superpoderes);

        return heroiRepository.save(heroi);
    }

    public Optional<Heroi> findById (Integer id) {
        return heroiRepository.findById(id);
    }


    @Transactional
    public ResponseEntity<?> atualizarHeroi(Integer id, Heroi request) {
        Optional<Heroi> heroiExistenteOpt = heroiRepository.findById(id);

        if (heroiExistenteOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Herói com ID " + id + " não encontrado.");
        }

        Heroi heroiExistente = heroiExistenteOpt.get();

        Optional<Heroi> heroiComMesmoNome = heroiRepository.findByNomeHeroi(request.getNomeHeroi());

        if (heroiComMesmoNome.isPresent() && !heroiComMesmoNome.get().getId().equals(id)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Nome de herói já está em uso por outro super-herói.");
        }
        heroiExistente.setNome(request.getNome());
        heroiExistente.setNomeHeroi(request.getNomeHeroi());
        heroiExistente.setAltura(request.getAltura());
        heroiExistente.setPeso(request.getPeso());
        heroiExistente.setDataNascimento(request.getDataNascimento());

        if (request.getSuperpoderes() != null) {
            heroiExistente.setSuperpoderes(new ArrayList<>(request.getSuperpoderes()));
        }

        Heroi heroiAtualizado = heroiRepository.save(heroiExistente);

        return ResponseEntity.ok(heroiAtualizado);
    }

    @Transactional
    public ResponseEntity<?> deletarHeroi(Integer id) {
        Optional<Heroi> heroiExistenteOpt = heroiRepository.findById(id);
        if (heroiExistenteOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Herói com ID " + id + " não encontrado.");
        }
        heroiRepository.deleteById(id);

        return ResponseEntity.ok("Herói com o ID " + id + " foi excluído com sucesso.");
    }



}
