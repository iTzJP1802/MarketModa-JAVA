package com.upc.MarketModa.Entidades;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Comentarios {
    @Id
    public String nombre;
    private String comentario;
    private String email;

    public Comentarios(){}

    @Override
    public String toString() {
        return "Comentarios{" +
                "nombre='" + nombre + '\'' +
                ", comentario='" + comentario + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public Comentarios(String nombre, String comentario, String email) {
        this.nombre = nombre;
        this.comentario = comentario;
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
