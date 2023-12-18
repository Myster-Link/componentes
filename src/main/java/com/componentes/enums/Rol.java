package com.componentes.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Rol {
    ADMINISTRADOR("Administrador"),
    EMPLEADO("Empleado");
    private final String Descripcion;
}
