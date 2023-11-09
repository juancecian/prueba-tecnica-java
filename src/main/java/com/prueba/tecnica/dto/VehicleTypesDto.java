package com.prueba.tecnica.dto;

import lombok.*;

@Builder
@Data
@AllArgsConstructor
public class VehicleTypesDto {

    private String IsPrimary;

    private String Name;

    private ConcessionaireDto concessionaire;
}
