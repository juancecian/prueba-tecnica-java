package com.prueba.tecnica.controllers;

import com.prueba.tecnica.dto.ManufacturerDto;
import com.prueba.tecnica.mocks.ManufacturerMockResponse;
import com.prueba.tecnica.services.impl.ManufacturerService;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;

import static org.mockito.Mockito.when;
import static org.springframework.test.util.AssertionErrors.assertTrue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

@WebMvcTest(ManufacturerControllerTest.class)
public class ManufacturerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private ManufacturerService manufacturerService;

    @InjectMocks
    private ManufacturerController manufacturerController;

    @Test
    public void testGetAllManufacturersWithoutSearch() throws Exception {
        List<ManufacturerDto> mockedResponse = ManufacturerMockResponse.getAllManufacturersWithoutSearch();
        when(manufacturerService.findAllManufacturers(anyString(), isNull()))
                .thenReturn(mockedResponse);
    }

    @Test
    public void testGetAllManufacturersWithTeslaCommonNameSearch() throws Exception {
        List<ManufacturerDto> mockedResponse = ManufacturerMockResponse.getAllManufacturersWithTeslaCommonNameSearch();
        when(manufacturerService.findAllManufacturers(anyString(), eq("Tesla")))
                .thenReturn(mockedResponse);
    }
}
