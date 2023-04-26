package com.vistadental.service;

import com.vistadental.domain.Paciente;
import java.util.List;


public interface PacienteService {
    public List<Paciente> getPacientes();
    
    public void save (Paciente paciente);
    
    public void delete (Paciente paciente);
    
    public Paciente getPaciente (Paciente paciente);
}
