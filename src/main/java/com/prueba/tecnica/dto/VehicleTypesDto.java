package com.prueba.tecnica.dto;

import lombok.*;

@Builder
@Data
@AllArgsConstructor
public class VehicleTypesDto {

    private Boolean IsPrimary;

    private String Name;

    private ManufacturerDto concessionaire;
}
