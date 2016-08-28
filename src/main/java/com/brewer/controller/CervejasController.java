package com.brewer.controller;

import com.brewer.model.Cerveja;
import com.brewer.repository.CervejaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class CervejasController {

    @Autowired
    private CervejaRepository cervejaRepository;

    @RequestMapping("cerveja/novo")
    public String novo(){
        Optional<Cerveja> cervejaOptional = cervejaRepository.findBySkuIgnoreCase("AA12345");
        return "cerveja/CadastroCerveja";
    }

}
