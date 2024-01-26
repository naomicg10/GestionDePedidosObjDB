package domain;

import java.util.List;

public interface DAO<T> {
    /* Basic CRUD operations */
    /* All write methods return the updated object */
    T save( T t);
    T update( T t);
    boolean delete(T t);
    T load( Integer id);
    List<T> loadAll();
}
