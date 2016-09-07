package com.brewer.services;

import com.brewer.model.Cerveja;
import com.brewer.repository.CervejaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CervejaService {

    @Autowired
    private CervejaRepository cervejaRepository;

    @Transactional
    public void salvar(Cerveja cerveja){
        cervejaRepository.save(cerveja);
    }

}
