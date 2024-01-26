package domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase que proporciona una conexión estática a una base de datos MySQL para el sistema de gestión de pedidos.
 */
public class MySQLConection {
    // Objeto Connection para la conexión a la base de datos
    private static final Connection connection;

    // Bloque estático para inicializar la conexión al cargarse la clase
    static {
        try {
            // Establecer la conexión a la base de datos MySQL
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestionpedidos", "root", "");
        } catch (SQLException e) {
            // Lanzar una excepción de tiempo de ejecución en caso de error al conectar
            throw new RuntimeException(e);
        }
    }

    /**
     * Método estático que devuelve la conexión a la base de datos.
     *
     * @return La conexión a la base de datos MySQL.
     */
    public static Connection getConnection() {
        return connection;
    }
}

