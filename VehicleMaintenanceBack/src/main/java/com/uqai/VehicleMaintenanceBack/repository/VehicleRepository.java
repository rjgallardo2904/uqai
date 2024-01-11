package com.uqai.VehicleMaintenanceBack.repository;

import com.uqai.VehicleMaintenanceBack.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle,Long> {

    @Query(value = "select * from vehicle v where v.date_buy between :dateBegin and :dataEnd",nativeQuery = true)
    List<Vehicle> findVhicleByDate(@Param("dateBegin") Date dateBegin,@Param("dataEnd") Date dataEnd);
}
