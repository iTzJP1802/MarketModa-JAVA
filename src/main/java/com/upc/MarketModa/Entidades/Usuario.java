package com.upc.MarketModa.Entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;

    private String nameUsuario;
    private String emailUsuario;
    private String passwordUsuario;
    private Date birthdateUsuario;
    private String phoneNumberUsuario;
    private String countryUsuario;

    public Usuario(){}

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nameUsuario='" + nameUsuario + '\'' +
                ", emailUsuario='" + emailUsuario + '\'' +
                ", passwordUsuario='" + passwordUsuario + '\'' +
                ", birthdateUsuario=" + birthdateUsuario +
                ", phoneNumberUsuario='" + phoneNumberUsuario + '\'' +
                ", countryUsuario='" + countryUsuario + '\'' +
                '}';
    }

    public Usuario(long id, String nameUsuario, String emailUsuario, String passwordUsuario, Date birthdateUsuario, String phoneNumberUsuario, String countryUsuario) {
        this.id = id;
        this.nameUsuario = nameUsuario;
        this.emailUsuario = emailUsuario;
        this.passwordUsuario = passwordUsuario;
        this.birthdateUsuario = birthdateUsuario;
        this.phoneNumberUsuario = phoneNumberUsuario;
        this.countryUsuario = countryUsuario;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameUsuario() {
        return nameUsuario;
    }

    public void setNameUsuario(String nameUsuario) {
        this.nameUsuario = nameUsuario;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public String getPasswordUsuario() {
        return passwordUsuario;
    }

    public void setPasswordUsuario(String passwordUsuario) {
        this.passwordUsuario = passwordUsuario;
    }

    public Date getBirthdateUsuario() {
        return birthdateUsuario;
    }

    public void setBirthdateUsuario(Date birthdateUsuario) {
        this.birthdateUsuario = birthdateUsuario;
    }

    public String getPhoneNumberUsuario() {
        return phoneNumberUsuario;
    }

    public void setPhoneNumberUsuario(String phoneNumberUsuario) {
        this.phoneNumberUsuario = phoneNumberUsuario;
    }

    public String getCountryUsuario() {
        return countryUsuario;
    }

    public void setCountryUsuario(String countryUsuario) {
        this.countryUsuario = countryUsuario;
    }
}
