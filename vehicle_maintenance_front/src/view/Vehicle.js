import React from 'react'
import { VehicleService, GuardarVehicle } from '../service/VehicleService';
import { VehicleModelService } from '../service/VehicleModelService';

import { useState } from 'react';
import { format } from 'date-fns';
import Modal from 'react-bootstrap/Modal';
import Button from 'react-bootstrap/Button';
export const Vehicle = () => {

  //Modal
  const [show, setShow] = useState(false);
  const handleClose = () => setShow(false);
  const handleShow = () => setShow(true);

  //Managment state of data 
  const { dataVehicle, loadding, error } = VehicleService("http://localhost:8585/api/allVehicle")
  const { dataModelVehicle } = VehicleModelService("http://localhost:8585/api/allVehicleModel")

  //Controll form
  const [placa, setPlaca] = useState("")
  const [modelo, setModelo] = useState({})
  const [year, setYear] = useState(0)
  const [dateBuy, setDateBuy] = useState("")
  const [Observation, setObservation] = useState("")
  const [vehicleSave, setVehicleSave] = useState("")



  if (error != null) {
    return <h1 >Error: "Hubo un error con la conexión al servidor"</h1>
  }

  if (loadding) {
    return (
      <div className="App">
        <h1>Cargando...</h1>
      </div>
    );
  }

  function guardarDatos() {

    setVehicleSave({
      placa,
      modelo,
      year,
      dateBuy,
      Observation
    })
    GuardarVehicle("",vehicleSave)
    
    console.log(vehicleSave);
  }

  function handleChange(e) {
    let {value } = e.target;
    const modelo = dataModelVehicle.find((element) => { return element.idModelVehicle === parseInt(value) })
    setModelo(modelo);
  }
  return (
    <>
      <div className="container">
        <h2>Lista de vehículos <span><button className='btn btn-primary' onClick={handleShow}>  Nuevo</button></span></h2>

        <table class="table table-hover">
          <thead>
            <tr>
              <th scope="col">Placa</th>
              <th scope="col">Modelo</th>
              <th scope="col">Año</th>
              <th scope="col">Fecha de Compra</th>
              <th scope="col">Observaciones</th>
              <th scope="col">Precio</th>
            </tr>
          </thead>
          <tbody>


            {dataVehicle?.map(
              (vehicle) => (
                <>
                  <tr>
                    <td>{vehicle.placa}</td>
                    <td>{vehicle.modelo.name}</td>
                    <td>{vehicle.year}</td>
                    <td>{format(vehicle.dateBuy, 'dd-MM-yyyy')}</td>
                    <td>{vehicle.observation}</td>
                    <td>{vehicle.price}</td>

                  </tr>
                </>
              )
            )}

          </tbody>
        </table>
      </div><Modal show={show} onHide={handleClose}>
        <Modal.Header closeButton>
          <Modal.Title>Datos del Vehiculo</Modal.Title>
        </Modal.Header>
        <form>
          <Modal.Body>
            <div class="input-group mb-3">
              <div class="input-group-prepend">
                <span class="input-group-text" id="basic-addon1">Placa</span>
              </div>
              <input
                type="text"
                required
                class="form-control"
                placeholder="Ej PDF-123"
                aria-label="Username"
                aria-describedby="basic-addon1"
                onChange={event => {
                  setPlaca(event.target.value);
                }}
              />
            </div>

            <div class="input-group mb-3">
              <div class="input-group-prepend">
                <span class="input-group-text" id="basic-addon1">Modelo</span>
              </div>
              <select class="custom-select" id="inputGroupSelect01" onChange={handleChange} required>
                <option value="" selected disabled hidden>Seleccionar</option>
                {dataModelVehicle?.map(
                  (vehicleModel) => (
                    <>
                      <option value={vehicleModel.idModelVehicle} >{vehicleModel.name}</option>
                    </>
                  )
                )}
              </select>
            </div>

            <div class="input-group mb-3">
              <div class="input-group-prepend">
                <span class="input-group-text" id="basic-addon1">Año</span>
              </div>
              <input 
                    type="number" 
                    placeholder='Ej. 2015' 
                    required 
                    className="form-control" 
                    onChange={event => {
                      setYear(parseInt(event.target.value));
                    }} />
            </div>

            <div class="input-group mb-3">
              <div class="input-group-prepend">
                <span class="input-group-text" id="basic-addon1">Fecha de Compra</span>
              </div>
              <input 
                    type="date" class="form-control" 
                    placeholder="Ej. 12-10-2022" 
                    required
                    onChange={event => {
                      setDateBuy(event.target.value);
                    }}
                    />
            </div>

            <div class="input-group mb-3">
              <div class="input-group-prepend">
                <span class="input-group-text" id="basic-addon1">Observaciones</span>
              </div>
              <input 
                   type="text" 
                   class="form-control" 
                   onChange={event => {
                    setObservation(event.target.value);
                  }}
              />
            </div>
          </Modal.Body>
          <Modal.Footer>
            <Button variant="secondary" onClick={handleClose}>
              Close
            </Button>
            <Button   onSubmit={guardarDatos} variant="primary" onClick={guardarDatos}>
              Guardar Cambios
            </Button>
          </Modal.Footer>
        </form>
      </Modal></>

  )
}
