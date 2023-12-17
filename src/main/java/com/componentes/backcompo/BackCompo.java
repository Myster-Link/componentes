package com.componentes.backcompo;

import com.componentes.controllers.*;
import com.componentes.entitys.Usuarios;
import com.componentes.enums.Rol;

public class BackCompo {

    public static void main(String[] args) {
        AuthController authController = new AuthController();

        Usuarios usuarios = new Usuarios();
        usuarios.setCedula(118800102);

        boolean result = authController.login(usuarios);

        System.out.println("" + result);

        PersistenceManager.closeEntityManagerFactory();
    }
}
