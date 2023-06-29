package com.upc.MarketModa.Negocio;

import com.upc.MarketModa.DTOS.UsuarioDTO;
import com.upc.MarketModa.Entidades.Usuario;
import com.upc.MarketModa.Repositorio.RepositorioUsuario;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NegocioUsuario {

    @Autowired
    private RepositorioUsuario repositorioUsuario;

    private UsuarioDTO convertToDto(Usuario usuario) {
        ModelMapper modelMapper = new ModelMapper();
        UsuarioDTO usuarioDTO = modelMapper.map(usuario, UsuarioDTO.class);
        return usuarioDTO;
    }

    private Usuario convertToEntity(UsuarioDTO usuarioDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Usuario usua = modelMapper.map(usuarioDTO, Usuario.class);
        return usua;
    }

    public Usuario registrar(Usuario usuario){
        Usuario u = repositorioUsuario.save(usuario);
        return u;
    }
    public List<Usuario> obtenerReporteGeneral(){
        return repositorioUsuario.findAll();
    }
    public Usuario actualizar(Long Id, Usuario usuario){
        Usuario UsuarioAntiguo = repositorioUsuario.findById(Id).get();
        usuario.setId(Id);//verificado que existe
        return repositorioUsuario.save(usuario); //actualizando con el enviado
    }
    public List<Usuario> obtenerReportexId(Long Id){
        return repositorioUsuario.findUsuarioById(Id);
    }
    public List<Usuario> IniciarSesion(String emailUsuario, String passwordUsuario){
        return repositorioUsuario.findUsuarioByEmailUsuarioAndAndPasswordUsuario(emailUsuario,passwordUsuario);
    }
    private List<UsuarioDTO> convertToLisDto(List<Usuario> list){
        return list.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
}
