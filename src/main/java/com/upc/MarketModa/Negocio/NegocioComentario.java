package com.upc.MarketModa.Negocio;

import com.upc.MarketModa.DTOS.ComentariosDTO;
import com.upc.MarketModa.Entidades.Comentarios;
import com.upc.MarketModa.Repositorio.RepositorioComentarios;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NegocioComentario {
    @Autowired
    private RepositorioComentarios repositorioComentarios;
    private ComentariosDTO convertToDto(Comentarios comentarios) {
        ModelMapper modelMapper = new ModelMapper();
        ComentariosDTO comentariosDTO = modelMapper.map(comentarios, ComentariosDTO.class);
        return comentariosDTO;
    }

    private Comentarios convertToEntity(ComentariosDTO comentariosDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Comentarios comen = modelMapper.map(comentariosDTO, Comentarios.class);
        return comen;
    }

    public Comentarios registrar(Comentarios comentarios){
        Comentarios c = repositorioComentarios.save(comentarios);
        return c;
    }
    public List<Comentarios> obtenerReporteGeneral(){
        return repositorioComentarios.findAll();
    }
}
