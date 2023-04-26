package com.vistadental.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import com.vistadental.domain.Paciente;
import com.vistadental.service.PacienteService;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @GetMapping("/paciente/listado")
    public String inicio(Model model) {
        var pacientes = pacienteService.getPacientes();
        model.addAttribute("pacientes", pacientes);
        return "/paciente/listado";
    }

    @GetMapping("/paciente/nuevo")
    public String nuevoPaciente(Paciente paciente) {
        return "/paciente/modificar";
    }

    @PostMapping("/paciente/guardar")
    public String guardarPaciente(Paciente paciente) {
        pacienteService.save(paciente);
        return "redirect:/paciente/listado";
    }

    @GetMapping("/paciente/modificar/{idPaciente}")
    public String modificarPaciente(Paciente paciente, Model model) {
        paciente = pacienteService.getPaciente(paciente);
        model.addAttribute("paciente", paciente);
        return "/paciente/modificar";
    }

    @GetMapping("/paciente/eliminar/{idPaciente}")
    public String eliminarPaciente(Paciente paciente) {
        pacienteService.delete(paciente);
        return "redirect:/paciente/listado";
    }

}
