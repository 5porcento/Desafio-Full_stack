package com.desafio.api.back.controller;

import com.desafio.api.back.entity.DTO.HeroiRequest;
import com.desafio.api.back.entity.DTO.HeroiResponse;
import com.desafio.api.back.entity.Heroi;
import com.desafio.api.back.entity.mapper.NewMapper;
import com.desafio.api.back.repository.HeroiRepository;
import com.desafio.api.back.repository.SuperPoderesRepository;
import com.desafio.api.back.service.HeroiService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/heroi")
public class HeroiController {

    private final HeroiRepository heroiRepository;
    private final SuperPoderesRepository superPoderesRepository;

    private final HeroiService heroiService;
    public HeroiController(HeroiService heroiService, HeroiRepository heroiRepository, SuperPoderesRepository superPoderesRepository) {
        this.heroiService = heroiService;
        this.heroiRepository = heroiRepository;
        this.superPoderesRepository = superPoderesRepository;
    }

    @GetMapping
    @Operation( summary = "Listagem de super-heróis",description = "Rota para a Listagem de Todos os super-heróis Cadastrados No Sistema")
    public ResponseEntity<?> findAll() {
        List<Heroi> herois = heroiService.listarTodosHerois();
        if (herois.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Nenhum super-herói cadastrado no sistema.");
        }
        return ResponseEntity.ok(herois);
    }

    @PostMapping
    @Operation(summary = "Cadastra um Novo Heroi", description = "Rota de inclusão de um novo super-herói na API")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Heroi Cadastrado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro na criação do Heroi")
    })
    public HeroiResponse save(@RequestBody HeroiRequest dto) {
        Heroi heroi = heroiService.salvarHeroi(dto);
        return NewMapper.toHeroiResponse(heroi);
    }

    //TODO: adicionar tratamento de erro
    @GetMapping("/pegar/{id}")
    @Operation(summary = "Exibi um heroi via id", description = "Rota de Listaegm de super-herói pelo seu id")

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Heroi Encontrado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Erro na Busca do Heroi")
    })

    public ResponseEntity<HeroiResponse> findHeroiById(@PathVariable Integer id) {
        return heroiService.findById(id)
                .map(heroi -> ResponseEntity.ok(NewMapper.toHeroiResponse(heroi)))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza um Heroi existente", description = "Rota de Atualização de um super-herói na API pelo seu id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Heroi Alterado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Heroi não encontrado,não foi possivel realizar a  Alteração do Heroi")
    })
    public ResponseEntity<?> atualizarHeroi(
            @Parameter(description = "Recebe o id no caminho da requisicao")
            @PathVariable Integer id,
            @Parameter(description = "Recebe os dados do heroi no corpo da requisicao")
            @RequestBody Heroi request
                ) {
        return heroiService.atualizarHeroi(id, request);
    }


    @DeleteMapping("/{id}")
    @Operation(summary = "Deleta um  Heroi", description = "Rota de Deleção de um  super-herói na API pelo seu id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Heroi Alterado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Heroi não encontrado,não foi possivel realizar a  Alteração do Heroi")
    })
    public ResponseEntity<?> deletarHeroi(@PathVariable Integer id) {
        return heroiService.deletarHeroi(id);
    }



}
