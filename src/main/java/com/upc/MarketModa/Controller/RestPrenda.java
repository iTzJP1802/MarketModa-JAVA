package com.upc.MarketModa.Controller;

import com.upc.MarketModa.DTOS.PrendaDTO;
import com.upc.MarketModa.Entidades.Prenda;
import com.upc.MarketModa.Negocio.NegocioPrenda;
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
public class RestPrenda {

    @Autowired
    private NegocioPrenda negocioPrenda;

    @PostMapping("/prenda")
    public PrendaDTO registrar(@RequestBody PrendaDTO prendaDTO){
        Prenda prenda;
        try {
            prenda = convertToEntity(prendaDTO);
            prenda = negocioPrenda.registrar(prenda);

        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No fue posible registrarlo");
        }
        return convertToDTO(prenda);
    }

    @GetMapping("/ListarPrendaGeneral")
    public ResponseEntity<List<PrendaDTO>> obtenerReporteGeneral(){
        List<PrendaDTO>prendaDTOS;
        try {
            prendaDTOS=convertToLisDto(negocioPrenda.obtenerReporteGeneral()) ;
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No fue posible obtener listado");
        }
        return new ResponseEntity<>(prendaDTOS,HttpStatus.OK);
    }

    @GetMapping("/ListarPrendaxId/{Id}") //3.-
    public List<PrendaDTO> obtenerReportexId(@PathVariable(value = "Id") Long Id){
        List<PrendaDTO> prendaDTOS;
        try {
            prendaDTOS = convertToLisDto(negocioPrenda.obtenerReportexId(Id));
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No fue posible obtener listado");
        }
        return prendaDTOS;
    }

    @PutMapping("/prenda/{Id}")
    public ResponseEntity<PrendaDTO> actualizar(@PathVariable(value = "Id") Long Id,
                                                 @RequestBody PrendaDTO prendaDTO){
        Prenda prenda;
        Prenda prendaActualizada;
        try {
            prenda = convertToEntity(prendaDTO);
            prendaActualizada = negocioPrenda.actualizar(Id, prenda);
            prendaDTO = convertToDTO(prendaActualizada);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No fue posible actualizar el usuario");
        }
        return  new ResponseEntity<PrendaDTO>(prendaDTO,HttpStatus.OK);
    }

    private PrendaDTO convertToDTO(Prenda prenda) {
        ModelMapper modelMapper = new ModelMapper();
        PrendaDTO prendaDTO = modelMapper.map(prenda, PrendaDTO.class);
        return prendaDTO;
    }

    private Prenda convertToEntity(PrendaDTO prendaDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Prenda pren = modelMapper.map(prendaDTO, Prenda.class);
        return pren;
    }
    private List<PrendaDTO> convertToLisDto(List<Prenda> list){
        return list.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
}
