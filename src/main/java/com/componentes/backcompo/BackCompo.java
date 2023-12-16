package com.componentes.backcompo;

import com.componentes.controllers.*;

public class BackCompo {

    public static void main(String[] args) {
        AuthController authController = new AuthController();

        authController.login();
        PersistenceManager.closeEntityManagerFactory();
    }

}
