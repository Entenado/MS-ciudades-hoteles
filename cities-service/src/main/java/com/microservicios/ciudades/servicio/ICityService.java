package com.microservicios.ciudades.servicio;

import com.microservicios.ciudades.dto.CityDTO;

public interface ICityService {

    public CityDTO getCitiesHotels(String name, String Country);

}
