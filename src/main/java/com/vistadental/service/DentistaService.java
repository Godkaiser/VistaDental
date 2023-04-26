package com.vistadental.service;

import com.vistadental.domain.Dentista;
import java.util.List;


public interface DentistaService {
    public List<Dentista> getDentistas();
    
    public void save (Dentista dentista);
    
    public void delete (Dentista dentista);
    
    public Dentista getDentista (Dentista dentista);
}
