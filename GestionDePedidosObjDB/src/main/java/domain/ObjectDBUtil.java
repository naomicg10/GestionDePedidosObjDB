package domain;

import lombok.Getter;
import lombok.extern.java.Log;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Log
/**
 * Clase utilitaria que proporciona un EntityManagerFactory estático para acceder a una base de datos ObjectDB.
 */
public class ObjectDBUtil {

    /**
     * Objeto EntityManagerFactory para la conexión a la base de datos ObjectDB.
     */
    @Getter
    private final static EntityManagerFactory entityManagerFactory;

    // Bloque estático para inicializar el EntityManagerFactory al cargarse la clase
    static {
        entityManagerFactory = Persistence.createEntityManagerFactory("data.odb");
    }
}

