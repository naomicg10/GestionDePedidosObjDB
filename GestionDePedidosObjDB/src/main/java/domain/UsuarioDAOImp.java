package domain;

import clases.Producto;
import clases.Usuario;
import excepciones.ContrasenhaIncorrectaException;
import excepciones.UsuarioIncorrectoException;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementación de la interfaz UsuarioDAO que proporciona métodos para realizar operaciones
 * de acceso a datos en la base de datos para la entidad Usuario.
 */
public class UsuarioDAOImp implements UsuarioDAO<Usuario> {

    /**
     * Valida un usuario en la base de datos en función del nombre de usuario y la contraseña proporcionados.
     *
     * @param nombre      Nombre de usuario a validar.
     * @param contraseña  Contraseña asociada al nombre de usuario.
     * @return Usuario validado si las credenciales son correctas.
     * @throws UsuarioIncorrectoException     Excepción lanzada si el nombre de usuario no es válido.
     * @throws ContrasenhaIncorrectaException Excepción lanzada si la contraseña no es válida.
     */
    public Usuario validateUser(String nombre, String contraseña) throws UsuarioIncorrectoException, ContrasenhaIncorrectaException {
        Usuario result = null;
        List<Usuario> lista = new ArrayList<>();

        EntityManager em = ObjectDBUtil.getEntityManagerFactory().createEntityManager();
        try {
            TypedQuery<Usuario> q = em.createQuery("select u from Usuario u where u.nombre=:nombre and u.contraseña=:contraseña", Usuario.class);
            q.setParameter("nombre", nombre);
            q.setParameter("contraseña", contraseña);

            try {
                lista = q.getResultList();
                if (!lista.isEmpty()) {
                    result = lista.get(0);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            em.close();
        }
    }

    /**
     * Obtiene un objeto Usuario desde la base de datos según su identificador.
     *
     * @param id Identificador del Usuario que se desea obtener.
     * @return Objeto Usuario obtenido desde la base de datos.
     */
    public Usuario load(Integer id) {
        Usuario salida = null;

        EntityManager em = ObjectDBUtil.getEntityManagerFactory().createEntityManager();
        try {
            TypedQuery<Usuario> query = em.createQuery("select u from Usuario u where u.id = :id", Usuario.class);
            query.setParameter("id", id);
            List<Usuario> resultado = query.getResultList();
            if (!resultado.isEmpty()) {
                salida = resultado.get(0);
            }
        } finally {
            em.close();
        }
        System.out.println(salida);
        return salida;
    }

    /**
     * Guarda una lista de usuarios en la base de datos.
     *
     * @param usuarios La lista de usuarios que se desea guardar en la base de datos.
     */
    public void saveAll(List<Usuario> usuarios) {
        EntityManager em = ObjectDBUtil.getEntityManagerFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            for (Usuario u : usuarios) {
                em.persist(u);
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}