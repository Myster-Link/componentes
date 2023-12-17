package com.componentes.entitys;

import java.io.Serializable;
import java.sql.Date;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "empleado_proyecto")
@Getter
@Setter
@NoArgsConstructor
@Entity
public class EmpleadoProyecto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "empleado_id")
    private Empleados empleado;

    @ManyToOne
    @JoinColumn(name = "proyecto_id")
    private Proyectos proyecto;

    private Date fechaInicio;
    private Date fechaFin;

    private static final long serialVersionUID = 1L;
}
