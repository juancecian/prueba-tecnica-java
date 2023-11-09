package com.prueba.tecnica.services;

import com.prueba.tecnica.model.Concessionaire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConcessionaireRepository extends JpaRepository<Concessionaire, Long> {
}
