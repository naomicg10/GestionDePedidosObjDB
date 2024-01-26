package clases;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class ItemPedido implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;  // Identificador único del elemento de pedidoç
    @Transient
    private String pedido;   // Descripción del pedido
    private Integer cantidad;    // Cantidad del producto solicitado
    @ManyToOne
    private Pedido cpedido; // Relación muchos a uno con la entidad Pedido
    @ManyToOne
    private Producto producto; // Producto relacionado con este elemento de pedido

    public ItemPedido() {
    }

    public ItemPedido(Integer id, String pedido, Integer cantidad, Pedido cpedido, Producto producto) {
        this.id = id;
        this.pedido = pedido;
        this.cantidad = cantidad;
        this.cpedido = cpedido;
        this.producto = producto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Pedido getCpedido() {
        return cpedido;
    }
    public void setCpedido(Pedido cpedido) {
        this.cpedido = cpedido;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getPedido() {
        return pedido;
    }

    public void setPedido(String pedido) {
        this.pedido = pedido;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
        return "ItemPedido{" +
                "id=" + id +
                ", pedido='" + pedido + '\'' +
                ", cantidad=" + cantidad +
                ", producto=" + producto +
                '}';
    }
}