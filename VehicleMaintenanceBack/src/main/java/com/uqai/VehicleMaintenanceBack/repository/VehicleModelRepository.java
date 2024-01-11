package com.uqai.VehicleMaintenanceBack.repository;

import com.uqai.VehicleMaintenanceBack.entity.ModelVehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleModelRepository extends JpaRepository<ModelVehicle,Long> {
}
