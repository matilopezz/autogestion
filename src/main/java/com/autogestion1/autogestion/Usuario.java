package com.autogestion1.autogestion;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String nombre;
    private String apellido;

    // Constructores, getters y setters
    public Usuario() {
    }

    public Usuario(String username, String password, String nombre, String apellido) {
        this.username = username;
        this.password = password;
        this.nombre = nombre;
        this.apellido = apellido;
    }
}
