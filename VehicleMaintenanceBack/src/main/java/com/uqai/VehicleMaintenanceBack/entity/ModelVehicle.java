package com.uqai.VehicleMaintenanceBack.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@Table(name = "modelVehicle")
public class ModelVehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idModelVehicle;
    String name;
}
