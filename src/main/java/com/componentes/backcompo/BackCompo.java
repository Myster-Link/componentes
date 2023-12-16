package com.componentes.backcompo;

import com.componentes.controllers.*;
import com.componentes.entitys.Usuarios;
import com.componentes.enums.Rol;
import java.time.LocalDateTime;

public class BackCompo {

    public static void main(String[] args) {
        AuthController authController = new AuthController();

        Usuarios usuarios = new Usuarios();
        usuarios.setCedula(118800102);
        usuarios.setNombre("Christopher");
        usuarios.setCorreo("sasa@gmail.com");
        usuarios.setClave("sasa");
        usuarios.setDireccion("asfasfasf");
        usuarios.setRol(Rol.USUARIO);
        usuarios.setSexo('m');
        usuarios.setFechaRegistro(LocalDateTime.now());

        authController.register(usuarios);

        PersistenceManager.closeEntityManagerFactory();
    }

}
