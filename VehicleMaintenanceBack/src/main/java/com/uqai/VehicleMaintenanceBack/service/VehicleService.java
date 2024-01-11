package com.uqai.VehicleMaintenanceBack.service;

import com.uqai.VehicleMaintenanceBack.entity.Vehicle;
import com.uqai.VehicleMaintenanceBack.repository.VehicleRepository;
import com.uqai.VehicleMaintenanceBack.service.impl.IVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class VehicleService implements IVehicleService {
    @Autowired
    private VehicleRepository vehicleRepository;
    @Override
    public Page<Vehicle> getAllVehicle(Pageable pePageable) {
        Page<Vehicle> listVehicleServ= vehicleRepository.findAll(pePageable);
        return listVehicleServ;
    }

    @Override
    public List<Vehicle> getVehicleByDate(Date dateBegin, Date dateEnd) {
        return vehicleRepository.findVhicleByDate(dateBegin,dateEnd);
    }

    @Override
    public Vehicle createVehicle(Vehicle vehicle) {
        Vehicle vehicleSave= vehicleRepository.save(vehicle);
        return vehicleSave;
    }

    @Override
    public Vehicle editVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    @Override
    public void deletaVehicle(Long id) {

    }

    @Override
    public List<Vehicle> getVehicleByPlaca() {
        return null;
    }

    @Override
    public Vehicle findByIdVehicle(Long idVehicle) {
        Optional<Vehicle> vehicleSearch=vehicleRepository.findById(idVehicle);
        return vehicleSearch.get();
    }
}
