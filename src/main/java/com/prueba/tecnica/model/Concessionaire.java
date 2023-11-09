package com.prueba.tecnica.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Table
@Getter
@Setter
public class Concessionaire {

    @Column
    private Integer id;

    @Column
    private String country;

    @Column
    private String name;

    @OneToMany(mappedBy = "concessionaire", cascade = CascadeType.ALL)
    private List<VehicleTypes> vehicleTypes;
}
