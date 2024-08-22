package com.microservicios.hoteles.servicios;

import com.microservicios.hoteles.DTO.Hotel;

import java.util.List;

public interface IHotelService {

    public List<Hotel> getHotelsByCityId(Long city_id);
}
