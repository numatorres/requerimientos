package net.monitorsoftware.requerimientos.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table
public class Usuario {

    @Id
    @SequenceGenerator(
            name = "secuencia_usuario",
            sequenceName="secuencia_usuario",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "secuencia_usuario"
    )

    private Long id;
    private String email;
    private String nombre;
    private String contrasena;
    private char estado;
    private Timestamp modificado;
    private Timestamp creado;

    public Usuario() { }

    public Usuario(Long id, String email, String nombre, String contrasena, char estado, Timestamp modificado, Timestamp creado) {
        this.id = id;
        this.email = email;
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.estado = estado;
        this.modificado = modificado;
        this.creado = creado;
    }

    public Usuario(String email, String nombre, String contrasena, char estado) {
        this.email = email;
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "usuario{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", nombre='" + nombre + '\'' +
                ", contrasena='" + contrasena + '\'' +
                ", estado='" + estado + '\'' +
                ", modificado=" + modificado +
                ", creado=" + creado +
                '}';
    }


    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email;  }

    public String getNombre() { return nombre; }

    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getContrasena() { return contrasena; }

    public void setContrasena(String contrasena) { this.contrasena = contrasena; }

    public char getEstado() { return estado; }

    public void setEstado(char estado) { this.estado = estado; }

    public Timestamp getModificado() { return modificado; }

    public void setModificado(Timestamp modificado) { this.modificado = modificado; }

    public Timestamp getCreado() { return creado; }

    public void setCreado(Timestamp creado) { this.creado = creado; }

}
