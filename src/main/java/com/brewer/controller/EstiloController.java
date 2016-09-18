package com.brewer.controller;

import com.brewer.model.Estilo;
import com.brewer.services.EstiloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class EstiloController {

    @Autowired
    private EstiloService estiloService;

    @RequestMapping("estilo/novo")
    public ModelAndView novo(Estilo estilo){
        ModelAndView modelAndView = new ModelAndView("estilo/CadastroEstilo");
        return modelAndView;
    }

    @PostMapping(value = "/estilo/novo")
    public ModelAndView salvar(@Valid Estilo estilo, BindingResult result, RedirectAttributes attributes){
        if(result.hasErrors()){
            return novo(estilo);
        }
        estiloService.salvar(estilo);
        attributes.addFlashAttribute("mensagem", "Estilo Salvo com Sucesso.");
        return new ModelAndView("redirect:/estilo/novo");
    }
}
