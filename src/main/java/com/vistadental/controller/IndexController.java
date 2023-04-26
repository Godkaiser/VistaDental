package com.vistadental.controller;

import com.vistadental.service.PacienteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
@Slf4j
public class IndexController {

@Autowired
    private PacienteService pacienteservice;
    @GetMapping("/")
    public String inicio(Model model) {
        var pacientes = pacienteservice.getPacientes();
        model.addAttribute("pacientes", pacientes);
        return "index";
    }

}
