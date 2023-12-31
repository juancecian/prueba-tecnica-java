package com.prueba.tecnica.dto;

import com.google.gson.annotations.SerializedName;
import lombok.*;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ManufacturerDto {

    private int Mfr_ID;

    private String Mfr_Name;

    private String Mfr_CommonName;

    private List<VehicleTypesDto> VehicleTypes;

    private String Country;

}
