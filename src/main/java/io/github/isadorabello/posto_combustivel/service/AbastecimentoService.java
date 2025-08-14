package io.github.isadorabello.posto_combustivel.service;

import io.github.isadorabello.posto_combustivel.infrastructure.entities.Abastecimento;
import io.github.isadorabello.posto_combustivel.infrastructure.entities.BombaCombustivel;
import io.github.isadorabello.posto_combustivel.infrastructure.repositories.AbastecimentoReposiory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AbastecimentoService {

    private final AbastecimentoReposiory repository;
    private final BombaCombustivelService bombaService;


    public  void criar(Integer idBomba, Long litros){
        BombaCombustivel bomba = bombaService.buscarPorId(idBomba);
        BigDecimal valorTotal = bomba.getTipoCombustivel().getPrecoPorLitro().multiply(BigDecimal.valueOf(litros));
        Abastecimento abastecimento = Abastecimento.builder()
                .valorTotal(valorTotal)
                .bombaCombustivel(bomba)
                .quantidadeLitros(litros)
                .dataAbastecimento(LocalDate.now())
                .build();

        repository.save(abastecimento);
    }

    public List<Abastecimento> buscar (){
        return repository.findAll();
    }

    public Abastecimento buscarPorId(Integer id){
        return repository.findById(id).orElseThrow(() -> new NullPointerException("Abastecimento com "+ id + " não encontrado"));
    }
}
