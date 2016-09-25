package com.brewer.repository;

import com.brewer.model.Estilo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EstiloRepository extends JpaRepository<Estilo, Long>{

    public Optional<Estilo> findByDescricaoIgnoreCase(String descricao);
}
