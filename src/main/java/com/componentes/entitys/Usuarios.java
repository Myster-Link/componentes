package com.componentes.entitys;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.*;

import com.componentes.enums.Rol;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Usuarios extends Persona implements Serializable {

    @Column(unique = true, nullable = false)
    private String nombre;

    @Column(unique = true, nullable = false)
    private String correo;

    @Column(nullable = false)
    private String clave;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Rol rol;

    @Column(name = "fecha_registro", nullable = false)
    private LocalDateTime fechaRegistro;

    private static final long serialVersionUID = 1L;
}
