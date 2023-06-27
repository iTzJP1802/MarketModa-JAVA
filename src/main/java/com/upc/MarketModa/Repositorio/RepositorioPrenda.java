package com.upc.MarketModa.Repositorio;

import com.upc.MarketModa.Entidades.Prenda;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepositorioPrenda extends JpaRepository<Prenda,Long> {
    List<Prenda> findPrendaById(Long Id);
}
