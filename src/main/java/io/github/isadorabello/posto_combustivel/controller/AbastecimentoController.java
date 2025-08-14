package io.github.isadorabello.posto_combustivel.controller;


import io.github.isadorabello.posto_combustivel.infrastructure.entities.Abastecimento;
import io.github.isadorabello.posto_combustivel.service.AbastecimentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("abastecimento")
public class AbastecimentoController {

    private final AbastecimentoService service;

    @PostMapping
    public ResponseEntity<Void> adicionarAbastecimento(@RequestParam("quantidadeLitros") Long litros,
                                                       @RequestParam("idBomba") Integer idBomba){
        service.criar(idBomba, litros);
        return ResponseEntity.accepted().build();
    }

    @GetMapping
    public ResponseEntity<List<Abastecimento>> buscarTodos(){
        List<Abastecimento> abastecimentos = this.service.buscar();
        return new ResponseEntity<>(abastecimentos, HttpStatus.OK);
        // return ResponseEntity.ok(service.buscar());
    }

}
