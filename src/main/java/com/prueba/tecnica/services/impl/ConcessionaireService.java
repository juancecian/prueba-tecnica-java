package com.prueba.tecnica.services.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.prueba.tecnica.dto.ApiResponseDto;
import com.prueba.tecnica.dto.ConcessionaireDto;
import com.prueba.tecnica.dto.VehicleTypesDto;
import com.prueba.tecnica.model.Concessionaire;
import com.prueba.tecnica.model.VehicleTypes;
import com.prueba.tecnica.services.ConcessionaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConcessionaireService {

    @Autowired
    private final ConcessionaireRepository concessionaireRepository;
    private final RestTemplate restTemplate;

    public ConcessionaireService(ConcessionaireRepository concessionaireRepository, RestTemplate restTemplate) {
        this.concessionaireRepository = concessionaireRepository;
        this.restTemplate = restTemplate;
    }

    @Value("${api.url}")
    private String URL_ENDPOINT;

    public List<ConcessionaireDto> findAllManufacturers(String format) {
        List<ConcessionaireDto> response = new ArrayList<>();
        long countDatabase = this.concessionaireRepository.count();

        if (countDatabase > 0) {

            List<Concessionaire> concessionaires = this.concessionaireRepository.findAll();

            for (Concessionaire concessionaire: concessionaires) {
                ConcessionaireDto concessionaireDto = ConcessionaireDto.builder()
                        .Mfr_ID(concessionaire.getMfrId())
                        .Mfr_Name(concessionaire.getMfrName())
                        .Mfr_CommonName(concessionaire.getMfrCommonName())
                        .Country(concessionaire.getCountry())
                        .VehicleTypes(buildVehicleTypes(concessionaire.getVehicleTypes()))
                        .build();

                response.add(concessionaireDto);
            }
        } else {
            ResponseEntity<String> res = restTemplate.getForEntity(URL_ENDPOINT + " /vehicles/getallmanufacturers?format=" + format, String.class);
            String jsonResponse = res.getBody();

            Gson gson = new GsonBuilder().create();
            ApiResponseDto apiResponseDto = gson.fromJson(jsonResponse, ApiResponseDto.class);
            response.addAll(apiResponseDto.getResults());
            persistDataInDatabase(apiResponseDto.getResults());
        }



        return response;
    }

    private void persistDataInDatabase(List<ConcessionaireDto> results) {
        for (ConcessionaireDto concessionary: results) {
            Concessionaire con = Concessionaire.builder()
                    .mfrId(concessionary.getMfr_ID())
                    .mfrName(concessionary.getMfr_Name())
                    .mfrCommonName(concessionary.getMfr_CommonName())
                    .country(concessionary.getCountry())
                    .build();
            this.concessionaireRepository.saveAndFlush(con);
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
