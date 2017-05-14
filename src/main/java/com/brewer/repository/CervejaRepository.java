package com.brewer.repository;

import com.brewer.model.Cerveja;
import com.brewer.repository.helper.CervejasRepositoryQueries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CervejaRepository extends JpaRepository<Cerveja, Long>, CervejasRepositoryQueries{

    public Optional<Cerveja> findBySkuIgnoreCase(String sku);
}
