package domain;

import clases.ItemPedido;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 * Implementación de la interfaz ItemPedidoDAO que proporciona métodos para realizar operaciones
 * de acceso a datos en la base de datos para la entidad ItemPedido.
 */
public class ItemPedidoDAOImp implements ItemPedidoDAO<ItemPedido> {

    /**
     * Carga un objeto ItemPedido desde la base de datos según el identificador proporcionado.
     *
     * @param id El identificador único del ItemPedido que se desea cargar.
     * @return El objeto ItemPedido cargado desde la base de datos, o null si no se encuentra.
     */
    public ItemPedido load(Integer id) {
        ItemPedido salida = null;

        EntityManager em = ObjectDBUtil.getEntityManagerFactory().createEntityManager();
        try {
            TypedQuery<ItemPedido> query = em.createQuery("select p from ItemPedido p where p.id = :id", ItemPedido.class);
            query.setParameter("id", id);
            var resultado = query.getResultList();
            if (resultado.size() > 0) {
                salida = resultado.get(0);
            }
        } finally {
            em.close();
        }
        System.out.println(salida);
        return salida;
    }

    /**
     * Elimina un objeto ItemPedido de la base de datos.
     *
     * @param item El objeto ItemPedido que se desea eliminar de la base de datos.
     * @return true si la operación de eliminación fue exitosa, false si no se encontró el objeto.
     */
    public boolean delete(ItemPedido item) {
        Boolean salida = false;
        EntityManager em = ObjectDBUtil.getEntityManagerFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            ItemPedido i = em.find(ItemPedido.class, item.getId());
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
     * Guarda un objeto ItemPedido en la base de datos.
     *
     * @param item El objeto ItemPedido que se desea guardar en la base de datos.
     * @return El objeto ItemPedido después de ser guardado en la base de datos.
     */
    public ItemPedido save(ItemPedido item) {
        EntityManager em = ObjectDBUtil.getEntityManagerFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(item);
            em.flush();
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return item;
    }
}
