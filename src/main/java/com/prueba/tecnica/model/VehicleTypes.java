package com.prueba.tecnica.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table
@Getter
@Setter
public class VehicleTypes {

    @Column
    private String isPrimary;
    @Column
    private String name;
    @ManyToOne
    @JoinColumn(name = "concessionaire_id")
    private Concessionaire concessionaire;
}
