package com.prueba.tecnica.services;

import com.prueba.tecnica.model.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ManufacturerRepository extends JpaRepository<Manufacturer, Long> {
    @Query("select man from Manufacturer man where man.mfrCommonName = ?1")
    List<Manufacturer> findByMfrCommonName(String commonName);
}
