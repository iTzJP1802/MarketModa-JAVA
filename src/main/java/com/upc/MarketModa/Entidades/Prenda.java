package com.upc.MarketModa.Entidades;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Prenda {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;
    private String path;

    public Prenda(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Prenda(long id, String path) {
        this.id = id;
        this.path = path;
    }

    @Override
    public String toString() {
        return "Prenda{" +
                "id=" + id +
                ", path='" + path + '\'' +
                '}';
    }
}
