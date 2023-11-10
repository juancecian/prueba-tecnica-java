package com.prueba.tecnica.controllers;

import com.prueba.tecnica.services.impl.ManufacturerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "manufacturers")
public class ManufacturerController {

    private static final Logger logger = LoggerFactory.getLogger(ManufacturerController.class);

    @Autowired
    private ManufacturerService manufacturerService;

    @GetMapping()
    @ResponseBody
    public ResponseEntity<Object> getAllManufacturers(@RequestParam(value = "format", required = true) String format, @RequestParam(value = "commonName", required = false) String commonName) {
        try {
            return new ResponseEntity<>(this.manufacturerService.findAllManufacturers(format, commonName), HttpStatus.OK);
        } catch(Exception e) {
            logger.error(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
