import { useEffect, useState } from "react";
export function VehicleModelService(url){
    const [dataModelVehicle, setdataModelVehicle] = useState(null);
    const [loaddingMode, setLoaddingModel] = useState(true);
    const [errorModel, setErrorModel] = useState(null);
    useEffect(() => {
        fetch(url)
            .then((response) => response.json())
            .then((vehicle) => setdataModelVehicle(vehicle))
            .catch((errorM)=>setErrorModel(errorM))
            .finally(()=>setLoaddingModel(false));
    },[]);
    return {dataModelVehicle,loaddingMode,errorModel};
}
