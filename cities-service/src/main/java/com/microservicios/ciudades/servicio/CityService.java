package com.microservicios.ciudades.servicio;

import com.microservicios.ciudades.dto.CityDTO;
import com.microservicios.ciudades.entidades.City;
import com.microservicios.ciudades.excepcion.CityNotFoundException;
import com.microservicios.ciudades.repository.IHotelsAPI;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CityService{

    @Autowired
    private IHotelsAPI hotelsAPI;

    List<City> cities = new ArrayList<City>();



    //@Override
    @CircuitBreaker(name="hotels-service", fallbackMethod="fallbackGetCitiesHotel")
    @Retry(name="hotels-service")
    public CityDTO getCitiesHotels(String name, String country) {

        City city = this.findCity(name, country);
        if (city == null) {
            throw new CityNotFoundException("City not found: " + name + ", " + country);
        }


        CityDTO cityDTO = new CityDTO();
        cityDTO.setCity_id(city.getCity_id());
        cityDTO.setName(city.getName());
        cityDTO.setCountry(city.getCountry());
        cityDTO.setContinent(city.getContinent());
        cityDTO.setState(city.getState());

        cityDTO.setHotelList(hotelsAPI.getHotelsByCityId(city.getCity_id()));

        //createException();
        return cityDTO;
    }

    public CityDTO fallbackGetCitiesHotel (Throwable throwable){
        System.out.println("No esta tomando el puto fallback");
        return new CityDTO(99999999L, "Fallible" , "Fallible" , "Fallible" , "Fallible", null) ;
    }


    public void createException() {
        throw new IllegalArgumentException("Prueba resilience y circuit braker");
    }




    public City findCity(String name, String country) {
        this.loadCities();
        for (City c:cities) {
            if (c.getName().equals(name)) {
                if (c.getCountry().equals(country)) {
                    return c;
                }

            }

        }
        return null;
    }

    public void loadCities () {

        cities.add(new City(1L, "Buenos Aires", "South America", "Argentina", "Buenos Aires"));
        cities.add(new City(2L, "Oberá", "South America", "Argentina", "Misiones"));
        cities.add(new City(3L, "Mexico City", "North America", "Mexico", "Mexico City"));
        cities.add(new City(4L, "Guadalajara", "North America", "Mexico", "Jalisco"));
        cities.add(new City(5L, "Bogotá", "South America", "Colombia", "Cundinamarca"));
        cities.add(new City(6L, "Medellín", "South America", "Colombia", "Antioquia"));
        cities.add(new City(7L, "Santiago", "South America", "Chile", "Santiago Metropolitan"));
        cities.add(new City(8L, "Valparaíso", "South America", "Chile", "Valparaíso"));
        cities.add(new City(9L, "Asunción", "South America", "Paraguay", "Asunción"));
        cities.add(new City(10L, "Montevideo", "South America", "Uruguay", "Montevideo"));
        cities.add(new City(11L, "Madrid", "Europe", "Spain", "Community of Madrid"));
        cities.add(new City(12L, "Barcelona", "Europe", "Spain", "Catalonia"));
        cities.add(new City(13L, "Seville", "Europe", "Spain", "Andalucia"));
        cities.add(new City(14L, "Monterrey", "North America", "Mexico", "Nuevo León"));
        cities.add(new City(15L, "Valencia", "Europe", "Spain", "Valencian Community"));

    }
}
