package com.upc.MarketModa.DTOS;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UsuarioDTO {

    public long id;
    private String nameUsuario;
    private String emailUsuario;
    private String passwordUsuario;
    private Date birthdateUsuario;
    private String phoneNumberUsuario;
    private String countryUsuario;
}
