package domain;


import excepciones.ContrasenhaIncorrectaException;
import excepciones.UsuarioIncorrectoException;

import java.sql.SQLException;
/**
 * La interfaz UsuarioDAO define métodos para acceder y manipular datos de la entidad Usuario en una base de datos.
 */
public interface UsuarioDAO<T> {
    public T validateUser(String nombre, String contraseña) throws SQLException, UsuarioIncorrectoException, ContrasenhaIncorrectaException;

    public T load(Integer id) throws SQLException;
}