package com.brewer.controller;


import com.brewer.model.TipoPessoa;
import com.brewer.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private EstadoRepository estadoRepository;

    @RequestMapping("novo")
    public ModelAndView novo(){
        ModelAndView mv = new ModelAndView("cliente/CadastroCliente");
        mv.addObject("tipoPessoas", TipoPessoa.values());
        mv.addObject("estados", estadoRepository.findAll());
        return mv;
    }
}
