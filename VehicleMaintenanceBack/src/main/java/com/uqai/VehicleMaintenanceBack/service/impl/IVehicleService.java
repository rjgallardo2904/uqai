package com.uqai.VehicleMaintenanceBack.service.impl;

import com.uqai.VehicleMaintenanceBack.entity.Vehicle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;

public interface IVehicleService {

    Page<Vehicle> getAllVehicle(Pageable pe);
    List<Vehicle> getVehicleByDate(Date dateBegin, Date dateEnd);

    Vehicle createVehicle(Vehicle vehicle);
    Vehicle editVehicle(Vehicle vehicle);

    void deletaVehicle( Long id);

    List<Vehicle> getVehicleByPlaca();

    Vehicle findByIdVehicle(Long idVehicle);
}
