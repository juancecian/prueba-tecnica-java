package com.prueba.tecnica.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Manufacturer {

    @Id
    private Integer mfrId;

    @Column
    private String country;

    @Column
    private String mfrCommonName;


    @Column
    private String mfrName;

    @OneToMany(mappedBy = "manufacturer", cascade = CascadeType.ALL)
    private List<VehicleTypes> vehicleTypes;
}
