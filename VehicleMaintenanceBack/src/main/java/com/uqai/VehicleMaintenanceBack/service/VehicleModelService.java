package com.uqai.VehicleMaintenanceBack.service;

import com.uqai.VehicleMaintenanceBack.entity.ModelVehicle;

import com.uqai.VehicleMaintenanceBack.repository.VehicleModelRepository;
import com.uqai.VehicleMaintenanceBack.service.impl.IVehicleModelService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleModelService implements IVehicleModelService {

    @Autowired
    private VehicleModelRepository vehicleModelRepository;
    @Override
    public List<ModelVehicle> getAllVehicleModel() {
        List<ModelVehicle> modelVehicleList= vehicleModelRepository.findAll();
        return modelVehicleList;
    }
}
