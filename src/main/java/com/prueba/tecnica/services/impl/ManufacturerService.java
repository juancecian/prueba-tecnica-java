package com.prueba.tecnica.services.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.prueba.tecnica.dto.ApiResponseDto;
import com.prueba.tecnica.dto.ManufacturerDto;
import com.prueba.tecnica.dto.VehicleTypesDto;
import com.prueba.tecnica.model.Manufacturer;
import com.prueba.tecnica.model.VehicleTypes;
import com.prueba.tecnica.services.ManufacturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class ManufacturerService {

    @Autowired
    private final ManufacturerRepository manufacturerRepository;
    private final RestTemplate restTemplate;

    public ManufacturerService(ManufacturerRepository manufacturerRepository, RestTemplate restTemplate) {
        this.manufacturerRepository = manufacturerRepository;
        this.restTemplate = restTemplate;
    }

    @Value("${api.url}")
    private String URL_ENDPOINT;

    public List<ManufacturerDto> findAllManufacturers(String format, String commonName) throws Exception {
        List<ManufacturerDto> response = new ArrayList<>();
        long countDatabase = this.manufacturerRepository.count();

        if (countDatabase > 0) {

            List<Manufacturer> concessionaires = commonName == null ? this.manufacturerRepository.findAll() : this.manufacturerRepository.findByMfrCommonName(commonName);

            if (concessionaires.isEmpty()) {
                throw new Exception("Not result for query");
            }

            for (Manufacturer concessionaire: concessionaires) {
                ManufacturerDto manufacturerDto = ManufacturerDto.builder()
                        .Mfr_ID(concessionaire.getMfrId())
                        .Mfr_Name(concessionaire.getMfrName())
                        .Mfr_CommonName(concessionaire.getMfrCommonName())
                        .Country(concessionaire.getCountry())
                        .VehicleTypes(buildVehicleTypes(concessionaire.getVehicleTypes()))
                        .build();

                response.add(manufacturerDto);
            }
        } else {
            ResponseEntity<String> res = restTemplate.getForEntity(URL_ENDPOINT + " /vehicles/getallmanufacturers?format=json", String.class);
            String jsonResponse = res.getBody();

            Gson gson = new GsonBuilder().create();
            ApiResponseDto apiResponseDto = gson.fromJson(jsonResponse, ApiResponseDto.class);
            response.addAll(apiResponseDto.getResults());
            persistDataInDatabase(apiResponseDto.getResults());
        }



        return response;
    }

    private void persistDataInDatabase(List<ManufacturerDto> results) {
        for (ManufacturerDto concessionary: results) {
            Manufacturer con = Manufacturer.builder()
                    .mfrId(concessionary.getMfr_ID())
                    .mfrName(concessionary.getMfr_Name())
                    .mfrCommonName(concessionary.getMfr_CommonName())
                    .country(concessionary.getCountry())
                    .build();
            this.manufacturerRepository.saveAndFlush(con);
        }
    }

    private List<VehicleTypesDto> buildVehicleTypes(List<VehicleTypes> vehicleTypes) {
        List<VehicleTypesDto> response = new ArrayList<>();
        for (VehicleTypes vehicleType: vehicleTypes) {
            VehicleTypesDto vehicleTypesDto = VehicleTypesDto.builder()
                    .IsPrimary(vehicleType.getIsPrimary())
                    .Name(vehicleType.getName())
                    .build();
            response.add(vehicleTypesDto);
        }
        return response;
    }
}
