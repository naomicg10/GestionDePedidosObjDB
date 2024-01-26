package domain;

import clases.Producto;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
/**
 * Implementación de la interfaz ProductoDAO que proporciona métodos para realizar operaciones
 * de acceso a datos en la base de datos para la entidad Producto.
 */
public class ProductoDAOImp{
    /**
     * Carga todos los objetos Producto desde la base de datos.
     *
     * @return Una lista de todos los productos almacenados en la base de datos.
     */
    public ArrayList<Producto> loadAll() {
        ArrayList<Producto>listaP=new ArrayList<>();
        ArrayList<Producto> salida  = new ArrayList<>(0);

        EntityManager em = ObjectDBUtil.getEntityManagerFactory().createEntityManager();
        try{
            TypedQuery<Producto> query = em.createQuery("select p from Producto p", Producto.class);
            salida = (ArrayList<Producto>) query.getResultList();
        } finally {
            em.close();
        }
        return salida;
    }
    /**
     * Guarda una lista de productos en la base de datos.
     *
     * @param productos La lista de productos que se desea guardar en la base de datos.
     */
    public void saveAll(List<Producto> productos){

        EntityManager em = ObjectDBUtil.getEntityManagerFactory().createEntityManager();
        try{
            em.getTransaction().begin();
            for(Producto p : productos){
                em.persist(p);
            }
            em.getTransaction().commit();
        }finally {
            em.close();
        }
    }
    /**
     * Trae una lista de productos desde la base de datos MySQL.
     *
     * @return Una lista de productos almacenados en la base de datos MySQL.
     */
    public ArrayList<Producto> traerLista(){
        Connection conexion = MySQLConection.getConnection();
        ArrayList<Producto> lista = new ArrayList<>();
        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery("select * from producto");
            while(rs.next()){
                Producto producto = new Producto(rs.getInt("id"),rs.getString("nombre"), rs.getDouble("precio"), rs.getInt("cantidad_disponible"));
                lista.add(producto);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }
}