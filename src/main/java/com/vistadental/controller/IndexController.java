package com.tienda.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import com.tienda.service.ArticuloService;

@Controller
@Slf4j
public class IndexController {

    @Autowired
    private ArticuloService articuloService;

    @GetMapping("/")
    public String inicio(Model model) {
        var articulos = articuloService.getArticulos(true);
        model.addAttribute("articulos", articulos);
        return "index";
    }

}
