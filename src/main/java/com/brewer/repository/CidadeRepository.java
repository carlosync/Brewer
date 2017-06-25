package com.brewer.repository;

import com.brewer.model.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface CidadeRepository extends JpaRepository<Cidade, Long>{

    public List<Cidade> findByEstadoCodigo(Long codigoEstado);
}
