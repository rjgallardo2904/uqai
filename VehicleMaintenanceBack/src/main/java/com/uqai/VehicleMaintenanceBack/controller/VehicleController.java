package com.uqai.VehicleMaintenanceBack.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.uqai.VehicleMaintenanceBack.entity.Vehicle;
import com.uqai.VehicleMaintenanceBack.service.VehicleService;
import com.uqai.VehicleMaintenanceBack.util.CalendarDay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("api")
public class VehicleController {
    @Autowired
    private VehicleService vehicleService;

    @GetMapping("allVehicle")
    public ResponseEntity<Page<Vehicle>> getAllVehicles(){
        final Pageable pePageable= PageRequest.of(0,10);
        Page<Vehicle> listVehickle=vehicleService.getAllVehicle(pePageable)   ;
        return new ResponseEntity<Page<Vehicle>>(listVehickle, HttpStatus.OK);
    }
    @PostMapping("createVehicle")
    public ResponseEntity<Vehicle> createVehicle(@RequestBody Vehicle vehicleRequest){
        Vehicle vehicleSave= new Vehicle();
        try {
            vehicleSave = vehicleService.createVehicle(vehicleRequest);
            updatePrice(vehicleSave);
            return new ResponseEntity<Vehicle>(vehicleSave, HttpStatus.OK);
        }catch (Exception e){
            System.out.println(e);
            return new ResponseEntity<Vehicle>(vehicleSave, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @PostMapping("editVehicle/{idVehiculo}")
    public ResponseEntity<Vehicle> editVehicle(@PathVariable Long idVehiculo,@RequestBody Vehicle vehicleRequest){
        Long idVehicle;
        idVehicle= idVehiculo;
        Vehicle vehicleSearch=vehicleService.findByIdVehicle(idVehicle);
         if(!vehicleSearch.getPlaca().isEmpty()){
             vehicleSearch=vehicleService.editVehicle(vehicleRequest);
             return new ResponseEntity<Vehicle>(vehicleSearch, HttpStatus.OK);
         }

        return new ResponseEntity<Vehicle>(vehicleSearch, HttpStatus.OK);
    }
    @GetMapping("dateMainte/{dateReques}")
    public ResponseEntity<List<Vehicle>> listVehicleMaint(@PathVariable String dateReques) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        List<Vehicle> vehicleListResponse=new ArrayList<>();
        String dateBegin=CalendarDay.calcularMantenimiento(dateReques);
        Date dateB=sdf.parse(dateBegin);
        Date dateE=sdf.parse(dateReques);
        List<Vehicle> vehicleListMaint=vehicleService.getVehicleByDate(dateB,dateE);
        vehicleListResponse.addAll(vehicleListMaint);
        DateFormat f = new SimpleDateFormat("EEEE");
        String strDateRequ = f.format(dateE);
        for (var element : vehicleListMaint) {
            String strDateElement=f.format(element.getDateBuy());
            if(!strDateElement.equals(strDateRequ)){
                vehicleListResponse.remove(element);
            }
        }
        return new ResponseEntity<List<Vehicle>>(vehicleListResponse, HttpStatus.OK);
    }
    public void updatePrice(Vehicle vehicleUpdate) throws JsonProcessingException {

        String uri="https://auto.jedai.workers.dev/?placa="+vehicleUpdate.getPlaca();
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);
        ObjectMapper mapper = new ObjectMapper();
        Map<String,Double> map = mapper.readValue(result, Map.class);
            vehicleUpdate.setPrice(map.get("precio"));
        vehicleService.editVehicle(vehicleUpdate);
    }
}
