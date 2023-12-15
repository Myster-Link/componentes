package com.componentes.entitys;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Proyectos implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String nombreProyecto;

    @ManyToOne
    @JoinColumn(name = "id_empleado_lider")
    private Empleados liderProyecto;

    @OneToMany(mappedBy = "proyecto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comentario> comentarios;

    @OneToMany(mappedBy = "proyecto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EmpleadoProyecto> empleadosEnProyecto;
    private static final long serialVersionUID = 1L;
}
