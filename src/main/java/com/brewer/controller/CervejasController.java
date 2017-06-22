package com.brewer.controller;

import com.brewer.controller.page.PageWrapper;
import com.brewer.model.Cerveja;
import com.brewer.model.Origem;
import com.brewer.model.Sabor;
import com.brewer.repository.CervejaRepository;
import com.brewer.repository.EstiloRepository;
import com.brewer.repository.filter.CervejaFilter;
import com.brewer.services.CervejaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping("/cerveja")
public class CervejasController {

    @Autowired
    private CervejaRepository cervejaRepository;

    @Autowired
    private EstiloRepository estiloRepository;

    @Autowired
    private CervejaService cervejaService;

    @RequestMapping("/novo")
    public ModelAndView novo(Cerveja cerveja){
        ModelAndView mv = new ModelAndView("cerveja/CadastroCerveja");
        mv.addObject("sabores", Sabor.values());
        mv.addObject("origens", Origem.values());
        mv.addObject("estilos", estiloRepository.findAll());
        return mv;
    }

    @RequestMapping(value = "/novo", method = RequestMethod.POST)
    public ModelAndView salvar(@Valid Cerveja cerveja, BindingResult bindingResult, RedirectAttributes attributes){
        if(bindingResult.hasErrors()){
            return novo(cerveja);
        }
        this.cervejaService.salvar(cerveja);
        attributes.addFlashAttribute("mensagem", "Cerveja salva com sucesso.");
        return new ModelAndView("redirect:/cerveja/novo");
    }

    @GetMapping
    public ModelAndView pesquisar(CervejaFilter cervejaFilter, BindingResult bindingResult,
                                  @PageableDefault(size = 3) Pageable pageable, HttpServletRequest request){
        ModelAndView mv = new ModelAndView("cerveja/PesquisaCervejas");
        mv.addObject("sabores", Sabor.values());
        mv.addObject("origens", Origem.values());
        mv.addObject("estilos", estiloRepository.findAll());

        PageWrapper<Cerveja> pageWrapper = new PageWrapper<>(cervejaRepository.filtra(cervejaFilter, pageable),request);
        mv.addObject("pagina", pageWrapper);
        return mv;
    }

}
