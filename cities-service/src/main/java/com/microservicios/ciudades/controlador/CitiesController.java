package com.microservicios.ciudades.controlador;

import com.microservicios.ciudades.dto.CityDTO;
import com.microservicios.ciudades.servicio.CityService;
import com.microservicios.ciudades.servicio.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cities")
public class CitiesController {

    @Autowired
    private CityService servCity;

    @GetMapping("/hotels")
    public CityDTO getCityAndHotels(@RequestParam String name, @RequestParam String country){
        return servCity.getCitiesHotels(name,country);
    }
}
