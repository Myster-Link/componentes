package com.componentes.contracts;

import java.sql.SQLException;
import java.util.List;

public interface ICrudController<T> {

    boolean create(T objeto);

    T read(int id);

    boolean update(T objeto);

    boolean delete(int id);

    List<T> readAll();

    List<T> readAllByUser(int userId);
}
