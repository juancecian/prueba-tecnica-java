package com.prueba.tecnica.model;

import lombok.*;

import javax.persistence.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class VehicleTypes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String isPrimary;

    @Column
    private String name;

    @ManyToOne
    @JoinColumn(name = "concessionaire_id")
    private Concessionaire concessionaire;
}
