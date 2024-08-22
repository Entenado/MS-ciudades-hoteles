package com.microservicios.hoteles.controaldor;

import com.microservicios.hoteles.DTO.Hotel;
import com.microservicios.hoteles.servicios.IHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelsController {
    @Autowired
    private IHotelService hotelService;

    @GetMapping("/{city_id}")
    public List<Hotel> hetHotelsBiCityId(@PathVariable Long city_id){
        return hotelService.getHotelsByCityId(city_id);
    }


}
