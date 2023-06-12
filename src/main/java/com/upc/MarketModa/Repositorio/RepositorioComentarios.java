package com.upc.MarketModa.Repositorio;

import com.upc.MarketModa.Entidades.Comentarios;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepositorioComentarios extends JpaRepository<Comentarios,Long> {
    List<Comentarios> findComentariosByNombre(String nombre);
}
