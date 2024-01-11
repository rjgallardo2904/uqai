# uqai
### Autor Richard Gallardo
---
## API
http://localhost:8585/api/createVehicle POST  Crear vehiculo

#### Ejemplo de Request
{
    "placa": "PDF0119",
    "modelo": {
        "idModelVehicle": 2,
        "name": "Sedan"
    },
    "year": 2023,
    "dateBuy": "2024-01-03T05:00:00.000+00:00",
    "observation": "Nada"
}

http://localhost:8585/api/allVehicle GET  Listar Vehiculos

http://localhost:8585/api/dateMainte/10-01-2024  GET  Vere vehiculos para mantenimiento

##Notas 

Para ejecutra el proyectoi se requiere actualizar los paquetes
*Spring boot: Request con paginación para soportar la carga de datos, consumiento api externo, calculo de mantenimento de vehiculos

##DDL

```
CREATE database vehicleMaintenance; 
{
  "firstName": "John",
  "lastName": "Smith",
  "age": 25
}
INSERT INTO public.model_vehicle
(id_model_vehicle, name)
VALUES(1, '4x4');
INSERT INTO public.model_vehicle
(id_model_vehicle, name)
VALUES(2, 'Sedan');
INSERT INTO public.vehicle
(price, "year", date_buy, id_model_vehicle, id_vehicle, observation, placa)
VALUES(22963.551, 2023, '2024-01-10 00:00:00.000', 2, 1, 'Nada', 'PDF0144');
INSERT INTO public.vehicle
(price, "year", date_buy, id_model_vehicle, id_vehicle, observation, placa)
VALUES(35875.265, 2023, '2024-01-11 00:00:00.000', 2, 2, 'Nada', 'PDF0174');
INSERT INTO public.vehicle
(price, "year", date_buy, id_model_vehicle, id_vehicle, observation, placa)
VALUES(43073.7708, 2023, '2024-01-12 00:00:00.000', 2, 3, 'Nada', 'PDF0114');
INSERT INTO public.vehicle
(price, "year", date_buy, id_model_vehicle, id_vehicle, observation, placa)
VALUES(34399.3183, 2023, '2024-01-13 00:00:00.000', 2, 4, 'Nada', 'PDF0119');
INSERT INTO public.vehicle
(price, "year", date_buy, id_model_vehicle, id_vehicle, observation, placa)
VALUES(37920.8992, 2023, '2024-01-13 00:00:00.000', 2, 5, 'Nada', 'PDF0119');


