package com.componentes.entitys;

import java.io.Serializable;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "experiencia_laboral")
@Getter
@Setter
@NoArgsConstructor
@Entity
public class ExperienciaLaboral implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "empleado_id")
    private Empleados empleado;

    private String curriculum;

    private static final long serialVersionUID = 1L;
}
