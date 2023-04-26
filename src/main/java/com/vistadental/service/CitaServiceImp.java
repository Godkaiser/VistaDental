package com.vistadental.service;

import com.vistadental.domain.Cita;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.vistadental.dao.CitaDao;

@Service
public class CitaServiceImp implements CitaService {

    @Autowired
    private CitaDao citaDao;

    @Override
    @Transactional(readOnly = true)
    public List<Cita> getCitas() {
        return (List<Cita>) citaDao.findAll();
    }

    @Override
    public void save(Cita cita) {
        citaDao.save(cita);
    }

    @Override
    public void delete(Cita cita) {
        citaDao.delete(cita);
    }

    @Override
    @Transactional(readOnly = true)
    public Cita getCita(Cita cita) {
        return citaDao.findById(cita.getIdCita()).orElse(null);
    }

}
