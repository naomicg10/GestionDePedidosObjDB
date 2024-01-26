package domain;


import clases.ItemPedido;
import clases.Pedido;

import javax.persistence.EntityManager;

import javax.persistence.EntityManager;

/**
 * Implementación de la interfaz PedidoDAO que proporciona métodos para realizar operaciones
 * de acceso a datos en la base de datos para la entidad Pedido.
 */
public class PedidoDAOImp implements PedidoDAO<Pedido> {

    /**
     * Elimina un objeto Pedido de la base de datos.
     *
     * @param pedido El objeto Pedido que se desea eliminar de la base de datos.
     * @return true si la operación de eliminación fue exitosa, false si no se encontró el objeto.
     */
    public boolean delete(Pedido pedido) {
        Boolean salida = false;
        EntityManager em = ObjectDBUtil.getEntityManagerFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            Pedido i = em.find(Pedido.class, pedido.getId());
            salida = (i != null);
            if (salida) {
                em.remove(i);
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return salida;
    }

    /**
     * Guarda un objeto Pedido en la base de datos.
     *
     * @param pedido El objeto Pedido que se desea guardar en la base de datos.
     * @return El objeto Pedido después de ser guardado en la base de datos.
     */
    public Pedido save(Pedido pedido) {
        EntityManager em = ObjectDBUtil.getEntityManagerFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(pedido);
            em.flush();
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return pedido;
    }

    /**
     * Actualiza un objeto Pedido en la base de datos.
     *
     * @param pedido El objeto Pedido que se desea actualizar en la base de datos.
     * @return El objeto Pedido después de ser actualizado en la base de datos.
     */
    public Pedido update(Pedido pedido) {
        EntityManager em = ObjectDBUtil.getEntityManagerFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(pedido);
            em.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            em.close();
        }
        return pedido;
    }
}