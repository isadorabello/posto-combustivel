package io.github.isadorabello.posto_combustivel.controller;

import io.github.isadorabello.posto_combustivel.infrastructure.entities.TipoCombustivel;
import io.github.isadorabello.posto_combustivel.service.TipoCombustivelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tipoCombustivel")
public class TipoCombustivelController {

    private final TipoCombustivelService service;

    @PostMapping
    public ResponseEntity<Void> adicionarTipoCombustivel(@RequestBody TipoCombustivel tipo){
        service.criar(tipo);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoCombustivel> buscarPorId(@PathVariable("id") Integer id){
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<TipoCombustivel>> buscarTodos(){
        List<TipoCombustivel> tipoCombustiveis = this.service.buscar();
        return new ResponseEntity<>(tipoCombustiveis, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable("id") Integer id){
        service.deletar(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public  ResponseEntity<Void> alterarTipoCombustivel (@RequestParam(name = "id") Integer id,
                                                         @RequestBody TipoCombustivel tipo){
        service.atualizar(id, tipo);
        return ResponseEntity.ok().build();

    }

}
