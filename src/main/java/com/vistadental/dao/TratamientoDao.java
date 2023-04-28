
package com.vistadental.dao;

import com.vistadental.domain.Tratamiento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TratamientoDao extends JpaRepository<Tratamiento, Long> {
    
    public Tratamiento findByNombre(String nombre);
    
}