package com.componentes.entitys;

import java.io.Serializable;
import java.sql.Date;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class EmpleadoProyecto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_empleado")
    private Empleados empleado;

    @ManyToOne
    @JoinColumn(name = "id_proyecto")
    private Proyectos proyecto;

    private Date fechaInicio;
    private Date fechaFin;

    private static final long serialVersionUID = 1L;
}
