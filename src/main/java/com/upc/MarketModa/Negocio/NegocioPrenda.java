package com.upc.MarketModa.Negocio;

import com.upc.MarketModa.DTOS.PrendaDTO;
import com.upc.MarketModa.Entidades.Prenda;
import com.upc.MarketModa.Entidades.Usuario;
import com.upc.MarketModa.Repositorio.RepositorioPrenda;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NegocioPrenda {

    @Autowired
    private RepositorioPrenda repositorioPrenda;

    private PrendaDTO convertToDto(Prenda prendas) {
        ModelMapper modelMapper = new ModelMapper();
        PrendaDTO prendaDTO = modelMapper.map(prendas, PrendaDTO.class);
        return prendaDTO;
    }

    private Prenda convertToEntity(PrendaDTO prendaDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Prenda pren = modelMapper.map(prendaDTO, Prenda.class);
        return pren;
    }

    public Prenda registrar(Prenda prendas){
        Prenda p = repositorioPrenda.save(prendas);
        return p;
    }

    public Prenda actualizar(Long Id, Prenda prenda){
        Prenda PrendaAntigua = repositorioPrenda.findById(Id).get();
        prenda.setId(Id);//verificado que existe
        return repositorioPrenda.save(prenda); //actualizando con el enviado
    }
    public List<Prenda> obtenerReporteGeneral(){
        return repositorioPrenda.findAll();
    }

    public List<Prenda> obtenerReportexId(Long Id){
        return repositorioPrenda.findPrendaById(Id);
    }
    private List<PrendaDTO> convertToLisDto(List<Prenda> list){
        return list.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
}
