package com.microservicios.ciudades.excepcion;

public class CityNotFoundException extends RuntimeException{
    public CityNotFoundException(String message) {
        super("la concha de tu madre");
    }
}
