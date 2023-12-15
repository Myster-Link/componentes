package com.componentes.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Rol {
    ADMINISTRADOR("Administrador"),
    USUARIO("USUARIO");
    private final String Descripcion;
}
