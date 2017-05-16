package com.brewer.repository.helper;


import com.brewer.model.Cerveja;
import com.brewer.repository.filter.CervejaFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CervejasRepositoryQueries {

    public Page<Cerveja> filtra(CervejaFilter cervejaFilter, Pageable pageable);
}
