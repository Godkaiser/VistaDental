package com.vistadental.dao;

import com.vistadental.domain.Paciente;
import org.springframework.data.repository.CrudRepository;

public interface PacienteDao extends CrudRepository<Paciente, Long> {

}
