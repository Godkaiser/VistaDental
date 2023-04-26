package com.vistadental.dao;

import com.vistadental.domain.Dentista;
import org.springframework.data.repository.CrudRepository;

public interface DentistaDao extends CrudRepository<Dentista, Long> {

}
