package com.brewer.controller;

import com.brewer.model.Estilo;
import com.brewer.services.EstiloService;
import com.brewer.services.exception.ObjetoJaExisteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
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
        try {
            estiloService.salvar(estilo);
        }catch (ObjetoJaExisteException ex){
            result.rejectValue("descricao", ex.getMessage(), ex.getMessage());
            return novo(estilo);
        }
        attributes.addFlashAttribute("mensagem", "Estilo Salvo com Sucesso.");
        return new ModelAndView("redirect:/estilo/novo");
    }

    @RequestMapping(value = "/estilos", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody ResponseEntity<?> salvarEstiloRapido(@RequestBody @Valid Estilo estilo, BindingResult result){
        if(result.hasErrors()){
            return ResponseEntity.badRequest().body(result.getFieldError("descricao").getDefaultMessage());
        }
        try {
            estilo = estiloService.salvar(estilo);
        }catch (ObjetoJaExisteException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

        return ResponseEntity.ok(estilo);
    }
}
