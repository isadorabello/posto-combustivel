package io.github.isadorabello.posto_combustivel.infrastructure.repositories;

import io.github.isadorabello.posto_combustivel.infrastructure.entities.Abastecimento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AbastecimentoReposiory extends JpaRepository<Abastecimento, Integer> {
}
