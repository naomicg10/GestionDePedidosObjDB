package clases;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
@Entity
public class Producto implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;                  // Identificador único del producto
    private String nombre;           // Nombre del producto
    private Double precio;           // Precio del producto
    private Integer cantidadDisponible;  // Cantidad disponible en inventario

    public Producto() {
    }

    public Producto(Integer id, String nombre, Double precio, Integer cantidadDisponible) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidadDisponible = cantidadDisponible;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(Integer cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }
}