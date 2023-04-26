package com.vistadental.service;

import com.vistadental.domain.Paciente;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.vistadental.dao.PacienteDao;

@Service
public class PacienteServiceImpl implements PacienteService {

    @Autowired
    private PacienteDao pacienteDao;

    @Override
    @Transactional(readOnly = true)
    public List<Paciente> getPacientes() {
        return (List<Paciente>) pacienteDao.findAll();
    }

    @Override
    public void save(Paciente paciente) {
        pacienteDao.save(paciente);
    }

    @Override
    public void delete(Paciente paciente) {
        pacienteDao.delete(paciente);
    }

    @Override
    @Transactional(readOnly = true)
    public Paciente getPaciente(Paciente paciente) {
        return pacienteDao.findById(paciente.getIdPaciente()).orElse(null);
    }

}
