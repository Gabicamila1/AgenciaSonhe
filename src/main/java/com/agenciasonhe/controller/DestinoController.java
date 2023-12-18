package com.agenciasonhe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.agenciasonhe.model.Destino;
import com.agenciasonhe.repository.DestinoRepository;

@Controller
@RequestMapping("/destino")
public class DestinoController {

    @Autowired
    private DestinoRepository destinoRepository;

    // lista todos os dados do banco destino
    @GetMapping
    public ModelAndView listar() {
        ModelAndView modelAndView = new ModelAndView("destino/index.html");

        List<Destino> destinos = destinoRepository.findAll();
        modelAndView.addObject("destinos", destinos);

        return modelAndView;
    }

    @GetMapping("/cadastrar")
    public ModelAndView cadastrar() {
        ModelAndView modelAndView = new ModelAndView("destino/cadastro");
        modelAndView.addObject("Destino", new Destino());

        return modelAndView;
    }

    @GetMapping("/{id}/editar")
    public ModelAndView editar(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("destino/edit");
        modelAndView.addObject("Destino", destinoRepository.getReferenceById(id));

        return modelAndView;
    }

    @PostMapping({ "/cadastrar", "/{id}/editar" })
    public String salvar(Destino destino) {

        destinoRepository.save(destino);

        return "redirect:/destino";
    }

    @GetMapping("/{id}/excluir")
    public ModelAndView excluir(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("redirect:/destino");

        destinoRepository.deleteById(id);

        return modelAndView;
    }
}