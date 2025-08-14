package io.github.isadorabello.posto_combustivel.controller;


import io.github.isadorabello.posto_combustivel.infrastructure.entities.BombaCombustivel;
import io.github.isadorabello.posto_combustivel.service.BombaCombustivelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/bombaCombustivel")
public class BombaCombustivelController {

    private final BombaCombustivelService service;

    @PostMapping
    public ResponseEntity<Void> adicionarBombaCombustivel(@RequestBody BombaCombustivel bomba){
        service.criar(bomba);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BombaCombustivel> buscarPorId(@PathVariable("id") Integer id){
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<BombaCombustivel>> buscarTodos(){
        List<BombaCombustivel> bombaCombustiveis = this.service.buscar();
        return new ResponseEntity<>(bombaCombustiveis, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable("id") Integer id){
        service.deletar(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public  ResponseEntity<Void> alterarBombaCombustivel (@RequestParam(name = "id") Integer id,
                                                         @RequestBody BombaCombustivel bomba){
        service.atualizar(id, bomba);
        return ResponseEntity.ok().build();

    }

}