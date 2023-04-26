package com.vistadental.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import com.vistadental.domain.Dentista;
import com.vistadental.service.DentistaService;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class DentistaController {

    @Autowired
    private DentistaService dentistaService;

    @GetMapping("/dentista/listado")
    public String inicio(Model model) {
        var dentistas = dentistaService.getDentistas();
        model.addAttribute("dentistas", dentistas);
        return "/dentista/listado";
    }

    @GetMapping("/dentista/nuevo")
    public String nuevoDentista(Dentista dentista) {
        return "/dentista/modificar";
    }

    @PostMapping("/dentista/guardar")
    public String guardarDentista(Dentista dentista) {
        dentistaService.save(dentista);
        return "redirect:/dentista/listado";
    }

    @GetMapping("/dentista/modificar/{idDentista}")
    public String modificarDentista(Dentista dentista, Model model) {
        dentista = dentistaService.getDentista(dentista);
        model.addAttribute("dentista", dentista);
        return "/dentista/modificar";
    }

    @GetMapping("/dentista/eliminar/{idDentista}")
    public String eliminarDentista(Dentista dentista) {
        dentistaService.delete(dentista);
        return "redirect:/dentista/listado";
    }

}
