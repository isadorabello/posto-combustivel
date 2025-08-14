package io.github.isadorabello.posto_combustivel.service;

import io.github.isadorabello.posto_combustivel.infrastructure.entities.TipoCombustivel;
import io.github.isadorabello.posto_combustivel.infrastructure.repositories.TipoCombustivelRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TipoCombustivelService {

    private TipoCombustivelRepository repository;

    public  void criar(TipoCombustivel tipo){
        repository.save(tipo);
    }

    public TipoCombustivel buscarPorId(Integer id){
        return repository.findById(id).orElseThrow(() -> new NullPointerException("Tipo de Combustível com "+ id + " não encontrado"));
    }

    public List<TipoCombustivel> buscar(){
        return repository.findAll();
    }

    @Transactional
    public  void deletar(Integer id){
        repository.deleteById(id);
    }

    // alterar para algo mais elaborado!!
    public  void atualizar(Integer id, TipoCombustivel tipo){
        TipoCombustivel tipoCombustivel = buscarPorId(id);
        tipo.setId(tipoCombustivel.getId());
        repository.save(tipo);
    }

}
