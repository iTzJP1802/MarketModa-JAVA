package com.upc.MarketModa.DTOS;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ComentariosDTO {

    private String nombre;
    private String comentario;
    private String email;
}
