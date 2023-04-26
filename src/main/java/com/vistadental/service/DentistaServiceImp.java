package com.vistadental.service;

import com.vistadental.domain.Dentista;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.vistadental.dao.DentistaDao;

@Service
public class DentistaServiceImp implements DentistaService {

    @Autowired
    private DentistaDao dentistaDao;

    @Override
    @Transactional(readOnly = true)
    public List<Dentista> getDentistas() {
        return (List<Dentista>) dentistaDao.findAll();
    }

    @Override
    public void save(Dentista dentista) {
        dentistaDao.save(dentista);
    }

    @Override
    public void delete(Dentista dentista) {
        dentistaDao.delete(dentista);
    }

    @Override
    @Transactional(readOnly = true)
    public Dentista getDentista(Dentista dentista) {
        return dentistaDao.findById(dentista.getIdDentista()).orElse(null);
    }

}
