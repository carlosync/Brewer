package com.brewer.repository.helper;


import com.brewer.model.Cerveja;
import com.brewer.repository.filter.CervejaFilter;

import java.util.List;

public interface CervejasRepositoryQueries {

    public List<Cerveja> filtra(CervejaFilter cervejaFilter);
}
