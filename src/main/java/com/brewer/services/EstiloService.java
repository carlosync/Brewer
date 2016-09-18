package com.brewer.services;

import com.brewer.model.Estilo;
import com.brewer.repository.EstiloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EstiloService {

    @Autowired
    private EstiloRepository estiloRepository;

    @Transactional
    public void salvar(Estilo estilo){
        estiloRepository.save(estilo);
    }

}
