package com.brewer.services;

import com.brewer.model.Estilo;
import com.brewer.repository.EstiloRepository;
import com.brewer.services.exception.ObjetoJaExisteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class EstiloService {

    @Autowired
    private EstiloRepository estiloRepository;

    @Transactional
    public Estilo salvar(Estilo estilo){
        Optional<Estilo> estiloOptional = estiloRepository.findByDescricaoIgnoreCase(estilo.getDescricao());
        if(estiloOptional.isPresent()){
            throw new ObjetoJaExisteException("Nome do estilo já está cadastrado.");
        }
        return estiloRepository.saveAndFlush(estilo);
    }

}
