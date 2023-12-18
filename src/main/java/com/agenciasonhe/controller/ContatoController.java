package com.agenciasonhe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.agenciasonhe.model.Contato;
import com.agenciasonhe.repository.ContatoRepository;

@Controller
@RequestMapping("/contato")
public class ContatoController {
    @Autowired
    private ContatoRepository contatoRepository;

    @GetMapping
    public ModelAndView listar() {
        ModelAndView modelAndView = new ModelAndView("contato/index.html");
        List<Contato> contatos = contatoRepository.findAll();
        modelAndView.addObject("contatos", contatos);

        return modelAndView;
    }

    @GetMapping("/cadastrar")
    public ModelAndView cadastrar() {
        ModelAndView modelAndView = new ModelAndView("contato/cadastro");

        modelAndView.addObject("contato", new Contato());

        return modelAndView;
    }

    @GetMapping("/{id}/editar")
    public ModelAndView editar(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("contato/edit");
        modelAndView.addObject("contato", contatoRepository.getReferenceById(id));

        return modelAndView;
    }

    @PostMapping({ "/cadastrar", "/{id}/editar" })
    public String salvar(Contato contato) {

        contatoRepository.save(contato);

        return "redirect:/contato";
    }

    @GetMapping("/{id}/excluir")
    public ModelAndView excluir(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("redirect:/contato");

        contatoRepository.deleteById(id);

        return modelAndView;
    }
}