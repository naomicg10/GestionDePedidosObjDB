package clases;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class Pedido implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;          // Identificador único del pedido
    private String codigo;   // Código único del pedido
    private Date fecha;      // Fecha en la que se realizó el pedido
    @ManyToOne
    private Usuario usuario;  // Usuario que realizó el pedido
    @OneToMany(mappedBy = "cpedido",fetch = FetchType.EAGER)
    private List<ItemPedido> items;  // Elementos de pedido asociados a este pedido
    private Double total;    // Total del pedido

    public Pedido() {
    }

    public Pedido(Integer id, String codigo, Date fecha, Usuario usuario, List<ItemPedido> items, Double total) {
        this.id = id;
        this.codigo = codigo;
        this.fecha = fecha;
        this.usuario = usuario;
        this.items = items;
        this.total = total;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<ItemPedido> getItems() {
        return items;
    }

    public void setItems(List<ItemPedido> items) {
        this.items = items;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", codigo='" + codigo + '\'' +
                ", fecha=" + fecha +
                ", usuario=" + getUsuario().getNombre() +
                ", total=" + total +
                "Lista de Items= "+items+
                '}';
    }
}