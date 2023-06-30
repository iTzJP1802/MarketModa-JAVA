package com.upc.MarketModa.Controller;

import com.upc.MarketModa.DTOS.UsuarioDTO;
import com.upc.MarketModa.Entidades.Usuario;
import com.upc.MarketModa.Negocio.NegocioUsuario;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"}) //Datos del Cliente que lo invoca
@RequestMapping("/api")
public class RestUsuario {

    @Autowired
    private NegocioUsuario negocioUsuario;

    @PostMapping("/usuario")
    public UsuarioDTO registrar(@RequestBody UsuarioDTO usuarioDTO){
        Usuario usuario;
        try {
            usuario = convertToEntity(usuarioDTO);
            usuario = negocioUsuario.registrar(usuario);

        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No fue posible registrarlo");
        }
        return convertToDTO(usuario);
    }

    @GetMapping("/ListarUsuarioGeneral")
    public ResponseEntity<List<UsuarioDTO>> obtenerReporteGeneral(){
        List<UsuarioDTO>usuarioDTOS;
        try {
            usuarioDTOS=convertToLisDto(negocioUsuario.obtenerReporteGeneral()) ;
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No fue posible obtener listado");
        }
        return new ResponseEntity<>(usuarioDTOS,HttpStatus.OK);
    }

    @GetMapping("/ListarUsuarioxId/{Id}") //3.-
    public List<UsuarioDTO> obtenerReportexId(@PathVariable(value = "Id") Long Id){
        List<UsuarioDTO> usuarioDTOS;
        try {
            usuarioDTOS = convertToLisDto(negocioUsuario.obtenerReportexId(Id));
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No fue posible obtener listado");
        }
        return usuarioDTOS;
    }

    @GetMapping("/IniciarSesion/{emailUsuario}/{passwordUsuario}") //4.-
    public List<UsuarioDTO> iniciarSesion(@PathVariable(value = "emailUsuario") String emailUsuario, @PathVariable(value="passwordUsuario") String passwordUsuario){
        List<UsuarioDTO> usuarioDTOS;
        try {
            usuarioDTOS = convertToLisDto(negocioUsuario.IniciarSesion(emailUsuario,passwordUsuario));
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No fue posible obtener listado");
        }
        return usuarioDTOS;
    }

    @PutMapping("/usuario/{Id}")
    public ResponseEntity<UsuarioDTO> actualizar(@PathVariable(value = "Id") Long Id,
                                                 @RequestBody UsuarioDTO usuarioDTO){
        Usuario usuario;
        Usuario usuarioActualizado;
        try {
            usuario = convertToEntity(usuarioDTO);
            usuarioActualizado = negocioUsuario.actualizar(Id, usuario);
            usuarioDTO = convertToDTO(usuarioActualizado);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No fue posible actualizar el usuario");
        }
        return  new ResponseEntity<UsuarioDTO>(usuarioDTO,HttpStatus.OK);
    }

    private UsuarioDTO convertToDTO(Usuario usuario) {
        ModelMapper modelMapper = new ModelMapper();
        UsuarioDTO usuarioDTO = modelMapper.map(usuario, UsuarioDTO.class);
        return usuarioDTO;
    }

    private Usuario convertToEntity(UsuarioDTO usuarioDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Usuario usua = modelMapper.map(usuarioDTO, Usuario.class);
        return usua;
    }
    private List<UsuarioDTO> convertToLisDto(List<Usuario> list){
        return list.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
}
