package com.brewer.repository;

import com.brewer.model.Cerveja;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CervejaRepository extends JpaRepository<Cerveja, Long>{

    public Optional<Cerveja> findBySkuIgnoreCase(String sku);
}
