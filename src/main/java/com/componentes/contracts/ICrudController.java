package com.componentes.contracts;

import java.sql.SQLException;
import java.util.List;

public interface ICrudController<T> {

    boolean create(T objeto) throws SQLException;

    T read(int id) throws SQLException;

    boolean update(T objeto) throws SQLException;

    boolean delete(int id) throws SQLException;

    List<T> readAll() throws SQLException;

    List<T> readAllByUser(int userId) throws SQLException;
}
