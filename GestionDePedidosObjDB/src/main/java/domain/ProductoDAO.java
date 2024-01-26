package domain;

import java.sql.SQLException;

/**
 * La interfaz ProductoDAO define métodos para acceder y manipular datos de la entidad Producto en una base de datos.
 */
public interface ProductoDAO<T> {

    public T load(Integer id) throws SQLException;
}