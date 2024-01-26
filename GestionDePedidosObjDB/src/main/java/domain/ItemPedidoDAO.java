package domain;

import java.sql.SQLException;

/**
 * La interfaz ItemPedidoDAO define métodos para acceder y manipular datos de la entidad ItemPedido en una base de datos.
 */
public interface ItemPedidoDAO<T> {

    public T load(Integer id) throws SQLException;
}