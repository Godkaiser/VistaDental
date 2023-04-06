package com.vistadental.controller;

import com.vistadental.service.ClienteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
@Slf4j
public class IndexController {

@Autowired
    private ClienteService clienteservice;
    @GetMapping("/")
    public String inicio(Model model) {
        var clientes = clienteservice.getClientes();
        model.addAttribute("clientes", clientes);
        return "index";
    }

}
