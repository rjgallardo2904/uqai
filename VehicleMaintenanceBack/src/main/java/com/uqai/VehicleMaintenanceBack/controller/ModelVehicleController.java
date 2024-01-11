package com.uqai.VehicleMaintenanceBack.controller;

import com.uqai.VehicleMaintenanceBack.entity.ModelVehicle;
import com.uqai.VehicleMaintenanceBack.service.VehicleModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class ModelVehicleController {
    @Autowired
    private VehicleModelService vehicleModelService;

    @GetMapping("allVehicleModel")
    public ResponseEntity<List<ModelVehicle>> getAllVehicles(){
        List<ModelVehicle> listVehickle=vehicleModelService.getAllVehicleModel()   ;
        return new ResponseEntity<List<ModelVehicle>>(listVehickle, HttpStatus.OK);
    }

}
