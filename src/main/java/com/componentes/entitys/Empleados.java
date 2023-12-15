package com.componentes.entitys;

import java.io.Serializable;
import jakarta.persistence.*;

import com.componentes.enums.Puesto;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Empleados extends Persona implements Serializable {

    @Column(nullable = false)
    private String nombre;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Puesto puesto;

    @OneToOne
    @JoinColumn(name = "id_usuario")
    private Usuarios usuario;

    private static final long serialVersionUID = 1L;
}
