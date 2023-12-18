package com.componentes.controllers;

import com.componentes.contracts.ICrudController;
import com.componentes.entitys.Vacaciones;
import com.componentes.services.VacacionService;
import jakarta.persistence.EntityManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VacacionController implements ICrudController<Vacaciones> {

    private EntityManager em = null;
    private VacacionService vacacionService;
    private List<Vacaciones> vacaciones;
    private Vacaciones vacacion;

    public VacacionController() {
        this.vacacionService = new VacacionService();

        if (em == null) {
            em = PersistenceManager.getEntityManager("BackCompPU");
        }
    }

    @Override
    public boolean create(Vacaciones objeto) {
        try {
            this.vacacionService.insertar(em, objeto);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Vacaciones read(int id) {
        try {
            vacacion = new Vacaciones();
            vacacion.setId(id);
            vacacion = this.vacacionService.encontrarPK(em, vacacion);
            return vacacion;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean update(Vacaciones objeto) {
        try {
            this.vacacionService.modificar(em, objeto);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(int id) {
        try {
            vacacion = new Vacaciones();
            vacacion.setId(id);
            this.vacacionService.eliminar(em, vacacion);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Vacaciones> readAll() {
        vacaciones = new ArrayList<>();

        try {
            vacaciones = this.vacacionService.listar(em);
            return vacaciones;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Vacaciones> readAllByUser(int userId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
