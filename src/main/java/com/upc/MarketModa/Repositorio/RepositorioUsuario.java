package com.upc.MarketModa.Repositorio;

import com.upc.MarketModa.Entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepositorioUsuario extends JpaRepository<Usuario,Long> {
    List<Usuario> findUsuarioById(Long Id);
    List<Usuario> findUsuarioByEmailUsuarioAndAndPasswordUsuario(String emailUsuario,String passwordUsuario);
}
