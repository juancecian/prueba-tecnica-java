package com.prueba.tecnica.dto;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Data
public class ApiResponseDto {

    @SerializedName("Count")
    private int count;

    @SerializedName("Message")
    private String message;

    @SerializedName("SearchCriteria")
    private String searchCriteria;

    @SerializedName("Results")
    private List<ManufacturerDto> results;

}
