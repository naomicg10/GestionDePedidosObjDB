package clases;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Usuario implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;            // Identificador único del usuario
    private String nombre;     // Nombre del usuario
    private String contraseña; // Contraseña del usuario
    private String email;// Dirección de correo electrónico del usuario
    @OneToMany(mappedBy = "usuario",fetch = FetchType.EAGER)

    private List<Pedido> pedidos;

    public Usuario() {
    }

    public Usuario(Integer id, String nombre, String contraseña, String email, List<Pedido> pedidos) {
        this.id = id;
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.email = email;
        this.pedidos = pedidos;
    }

    public Usuario(String nombre, String contraseña, String email, List<Pedido> pedidos) {
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.email = email;
        this.pedidos = pedidos;
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

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", contraseña='" + contraseña + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}