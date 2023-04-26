package com.vistadental.service;

import com.vistadental.domain.Cita;
import java.util.List;


public interface CitaService {
    public List<Cita> getCitas();
    
    public void save (Cita cita);
    
    public void delete (Cita cita);
    
    public Cita getCita (Cita cita);
}
