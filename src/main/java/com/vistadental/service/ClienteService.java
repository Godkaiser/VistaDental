package com.vistadental.service;

import com.vistadental.domain.Cliente;
import java.util.List;


public interface ClienteService {
    public List<Cliente> getClientes();
    
    public void save (Cliente cliente);
    
    public void delete (Cliente cliente);
    
    public Cliente getCliente (Cliente cliente);
}
