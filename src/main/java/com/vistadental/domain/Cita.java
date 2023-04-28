package com.vistadental.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "citas")
public class Cita implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cita")
    private Long idCita;
    String fecha;
    String hora;

    public Cita() {
    }

    public Cita(Long idCita, String fecha, String hora) {
        this.idCita = idCita;
        this.fecha = ""+(new Date());
        this.hora = hora;
    }

    
}
