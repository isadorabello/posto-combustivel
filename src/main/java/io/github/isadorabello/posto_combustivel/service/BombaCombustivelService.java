package io.github.isadorabello.posto_combustivel.service;

import io.github.isadorabello.posto_combustivel.infrastructure.entities.BombaCombustivel;
import io.github.isadorabello.posto_combustivel.infrastructure.repositories.BombaCombustivelRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BombaCombustivelService {

    private BombaCombustivelRepository repository;

    public  void criar(BombaCombustivel bomba){
        repository.save(bomba);
    }

    public BombaCombustivel buscarPorId(Integer id){
        return repository.findById(id).orElseThrow(() -> new NullPointerException("Bomba de Combustível com "+ id + " não encontrado"));
    }

    public List<BombaCombustivel> buscar(){
        return repository.findAll();
    }

    @Transactional
    public  void deletar(Integer id){
        repository.deleteById(id);
    }

    // alterar para algo mais elaborado!!
    public  void atualizar(Integer id, BombaCombustivel bomba){
        BombaCombustivel bombaCombustivel = buscarPorId(id);
        bomba.setId(bombaCombustivel.getId());
        repository.save(bomba);
    }

}
