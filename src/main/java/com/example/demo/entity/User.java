package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@Entity
@Table(name = "usuario") // Nombre de la tabla en la base de datos

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int usuarioID;

    @Column(nullable = false, unique = true)
    private String nombreUsuario;

    @Column(nullable = false)
    private String hashContraseña;

    @Column(nullable = false, unique = true)
    private String correoElectrónico;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Rol rol;

    @Column(nullable = false)
    private LocalDateTime fechaCreación = LocalDateTime.now();

    // Constructores
    public User() {
    }

    public User(String nombreUsuario, String hashContraseña, String correoElectrónico, Rol rol) {
        this.nombreUsuario = nombreUsuario;
        this.hashContraseña = hashContraseña;
        this.correoElectrónico = correoElectrónico;
        this.rol = rol;
    }

    // Getters y setters
    public int getUsuarioID() {
        return usuarioID;
    }

    public void setUsuarioID(int usuarioID) {
        this.usuarioID = usuarioID;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getHashContraseña() {
        return hashContraseña;
    }

    public void setHashContraseña(String hashContraseña) {
        this.hashContraseña = hashContraseña;
    }

    public String getCorreoElectrónico() {
        return correoElectrónico;
    }

    public void setCorreoElectrónico(String correoElectrónico) {
        this.correoElectrónico = correoElectrónico;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public LocalDateTime getFechaCreación() {
        return fechaCreación;
    }

    public void setFechaCreación(LocalDateTime fechaCreación) {
        this.fechaCreación = fechaCreación;
    }

    // Enum para los roles
    public enum Rol {
        ADMINISTRADOR, EMPLEADO, CLIENTE
    }

    // toString
    @Override
    public String toString() {
        return "Usuario{" +
               "usuarioID=" + usuarioID +
               ", nombreUsuario='" + nombreUsuario + '\'' +
               ", hashContraseña='" + hashContraseña + '\'' +
               ", correoElectrónico='" + correoElectrónico + '\'' +
               ", rol=" + rol +
               ", fechaCreación=" + fechaCreación +
               '}';
    }

    @OneToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @OneToMany(mappedBy = "usuario")
    private Set<Alquiler> alquileres;

    public Set<Alquiler> getAlquileres() {
        return alquileres;
    }

    public void setAlquileres(Set<Alquiler> alquileres) {
        this.alquileres = alquileres;
    }

}
