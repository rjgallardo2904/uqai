import { useEffect, useState } from "react";
export function VehicleService(url){
    const [dataVehicle, setdataVehiclea] = useState(null);
    const [loadding, setLoadding] = useState(true);
    const [error, setError] = useState(null);
    useEffect(() => {
        
        fetch(url)
            .then((response) => response.json())
            .then((vehicle) => setdataVehiclea(vehicle.content))
            .catch((errorM)=>setError(errorM))
            .finally(()=>setLoadding(false));
    },[]);
    return {dataVehicle,loadding,error};
}
export function GuardarVehicle(url,vehiculo){
    console.log(JSON.stringify(vehiculo));
    const requestOptions = {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(vehiculo)
    };
    fetch('http://localhost:8585/api/createVehicle', requestOptions)
        .then(response => response.json())
        .then(data => console.log(data));
}
