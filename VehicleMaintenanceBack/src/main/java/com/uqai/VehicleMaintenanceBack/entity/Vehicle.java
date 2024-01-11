package com.uqai.VehicleMaintenanceBack.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter @Setter
@Table(name = "vehicle")
public class Vehicle {
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVehicle;
    String placa;
    @ManyToOne
    @JoinColumn(name = "idModelVehicle")
    //@NotBlank
    private ModelVehicle modelo;
    private int year;
    private Date dateBuy;
    private String Observation;
    private Double price;



}
