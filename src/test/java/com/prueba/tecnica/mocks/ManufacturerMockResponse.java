package com.prueba.tecnica.mocks;

import com.prueba.tecnica.dto.ManufacturerDto;
import com.prueba.tecnica.dto.VehicleTypesDto;
import com.prueba.tecnica.model.Manufacturer;
import com.prueba.tecnica.model.VehicleTypes;

import java.util.ArrayList;
import java.util.List;

public class ManufacturerMockResponse {

    public static List<ManufacturerDto> getAllManufacturersWithoutSearch() {

        List<ManufacturerDto> manufacturerDtos = new ArrayList<>();

        ManufacturerDto mockManufacturer = new ManufacturerDto();
        mockManufacturer.setCountry("UNITED KINGDOM (UK)");
        mockManufacturer.setMfr_CommonName("Aston Martin");
        mockManufacturer.setMfr_ID(956);
        mockManufacturer.setMfr_Name("ASTON MARTIN LAGONDA LIMITED");

        List<VehicleTypesDto> vehicleTypes = new ArrayList<>();
        vehicleTypes.add(VehicleTypesDto.builder().IsPrimary(false).Name("Passenger Car").build());
        vehicleTypes.add(VehicleTypesDto.builder().IsPrimary(false).Name("Multipurpose Passenger Vehicle (MPV)").build());
        mockManufacturer.setVehicleTypes(vehicleTypes);

        manufacturerDtos.add(mockManufacturer);
        return manufacturerDtos;
    }

    public static List<ManufacturerDto> getAllManufacturersWithTeslaCommonNameSearch() {

        List<ManufacturerDto> manufacturerDtos = new ArrayList<>();

        ManufacturerDto mockManufacturer = new ManufacturerDto();
        mockManufacturer.setCountry("UNITED STATES (USA)");
        mockManufacturer.setMfr_CommonName("Tesla");
        mockManufacturer.setMfr_ID(955);
        mockManufacturer.setMfr_Name("TESLA, INC.");

        List<VehicleTypesDto> vehicleTypes = new ArrayList<>();
        vehicleTypes.add(VehicleTypesDto.builder().IsPrimary(true).Name("Passenger Car").build());
        vehicleTypes.add(VehicleTypesDto.builder().IsPrimary(false).Name("Truck").build());
        vehicleTypes.add(VehicleTypesDto.builder().IsPrimary(false).Name("Multipurpose Passenger Vehicle (MPV)").build());
        mockManufacturer.setVehicleTypes(vehicleTypes);

        manufacturerDtos.add(mockManufacturer);
        return manufacturerDtos;
    }
}
