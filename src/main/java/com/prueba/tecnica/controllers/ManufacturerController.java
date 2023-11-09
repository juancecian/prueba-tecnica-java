package com.prueba.tecnica.controllers;

import com.prueba.tecnica.services.impl.ConcessionaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "manufacturers")
public class ManufacturerController {

    @Autowired
    private ConcessionaireService concessionaireService;

    @GetMapping()
    @ResponseBody
    public ResponseEntity<Object> getAllManufacturers(@RequestParam(value = "format") String format) {
        try {
            return new ResponseEntity<>(this.concessionaireService.findAllManufacturers(format), HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
