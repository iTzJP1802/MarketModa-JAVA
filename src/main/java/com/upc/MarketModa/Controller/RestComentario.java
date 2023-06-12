package com.upc.MarketModa.Controller;

import com.upc.MarketModa.DTOS.ComentariosDTO;
import com.upc.MarketModa.Entidades.Comentarios;
import com.upc.MarketModa.Negocio.NegocioComentario;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class RestComentario {

    @Autowired
    private NegocioComentario negocioComentario;

    @PostMapping("/comentario")
    public ComentariosDTO registrar(@RequestBody ComentariosDTO comentariosDTO){
        Comentarios comentarios;
        try {
            comentarios = convertToEntity(comentariosDTO);
            comentarios = negocioComentario.registrar(comentarios);
        }catch (Exception e){
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No fue posible registrarlo");
        }
        return convertToDTO(comentarios);
    }

    @GetMapping("/ListarComentarioGeneral")
    public ResponseEntity<List<ComentariosDTO>> obtenerReporteGeneral(){
        List<ComentariosDTO>comentariosDTOS;
        try {
            comentariosDTOS=convertToLisDto(negocioComentario.obtenerReporteGeneral()) ;
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No fue posible obtener listado");
        }
        return new ResponseEntity<>(comentariosDTOS,HttpStatus.OK);
    }
    private ComentariosDTO convertToDTO(Comentarios comentarios) {
        ModelMapper modelMapper = new ModelMapper();
        ComentariosDTO comentariosDTO = modelMapper.map(comentarios, ComentariosDTO.class);
        return comentariosDTO;
    }

    private Comentarios convertToEntity(ComentariosDTO comentariosDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Comentarios comen = modelMapper.map(comentariosDTO, Comentarios.class);
        return comen;
    }
    private List<ComentariosDTO> convertToLisDto(List<Comentarios> list){
        return list.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
}
