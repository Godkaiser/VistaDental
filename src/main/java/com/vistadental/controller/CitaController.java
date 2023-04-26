package com.vistadental.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import com.vistadental.domain.Cita;
import com.vistadental.service.CitaService;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class CitaController {

    @Autowired
    private CitaService citaService;

    @GetMapping("/cita/listado")
    public String inicio(Model model) {
        var citas = citaService.getCitas();
        model.addAttribute("citas", citas);
        return "/cita/listado";
    }

    @GetMapping("/cita/nuevo")
    public String nuevoCita(Cita cita) {
        return "/cita/modificar";
    }

    @PostMapping("/cita/guardar")
    public String guardarCita(Cita cita) {
        citaService.save(cita);
        return "redirect:/cita/listado";
    }

    @GetMapping("/cita/modificar/{idCita}")
    public String modificarCita(Cita cita, Model model) {
        cita = citaService.getCita(cita);
        model.addAttribute("cita", cita);
        return "/cita/modificar";
    }

    @GetMapping("/cita/eliminar/{idCita}")
    public String eliminarCita(Cita cita) {
        citaService.delete(cita);
        return "redirect:/cita/listado";
    }

}
