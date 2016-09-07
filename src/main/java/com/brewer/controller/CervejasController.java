package com.brewer.controller;

import com.brewer.model.Cerveja;
import com.brewer.model.Origem;
import com.brewer.model.Sabor;
import com.brewer.repository.CervejaRepository;
import com.brewer.repository.EstiloRepository;
import com.brewer.services.CervejaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class CervejasController {

    @Autowired
    private CervejaRepository cervejaRepository;

    @Autowired
    private EstiloRepository estiloRepository;

    @Autowired
    private CervejaService cervejaService;

    @RequestMapping("cerveja/novo")
    public ModelAndView novo(Cerveja cerveja){
        ModelAndView mv = new ModelAndView("cerveja/CadastroCerveja");
        mv.addObject("sabores", Sabor.values());
        mv.addObject("origens", Origem.values());
        mv.addObject("estilos", estiloRepository.findAll());
        return mv;
    }

    @RequestMapping(value = "cerveja/novo", method = RequestMethod.POST)
    public ModelAndView salvar(Cerveja cerveja, BindingResult bindingResult, RedirectAttributes attributes){
        if(bindingResult.hasErrors()){
            return novo(cerveja);
        }
        this.cervejaService.salvar(cerveja);
        attributes.addFlashAttribute("mensagem", "Cerveja salva com sucesso.");
        return new ModelAndView("redirect:/cerveja/novo");
    }

}
