package com.brewer.controller;


import com.brewer.model.TipoPessoa;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    @RequestMapping("novo")
    public ModelAndView novo(){
        ModelAndView mv = new ModelAndView("cliente/CadastroCliente");
        mv.addObject("tipoPessoas", TipoPessoa.values());
        return mv;
    }
}
