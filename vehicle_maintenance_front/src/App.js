import './App.css';
import { Vehicle } from './view/Vehicle';
import { Fragment } from 'react';
import { BrowserRouter, Routes, Route } from "react-router-dom";
import { HeaderHome } from './shared/HeaderHome';
import { Maintenance } from './view/Maintenance';



function App() {
  return (
    
    <Fragment>
      <HeaderHome></HeaderHome>
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<Vehicle />}></Route>  
          <Route path="/maintenance" element={<Maintenance />} />
            
          
        </Routes>
      </BrowserRouter>
    </Fragment>
  );
}

export default App;
