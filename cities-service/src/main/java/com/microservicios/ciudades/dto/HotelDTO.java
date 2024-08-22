package com.microservicios.ciudades.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class HotelDTO {
private Long id;
private String name;
private int stars;
private Long city_id;
}
