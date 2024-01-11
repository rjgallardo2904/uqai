import React from 'react'

export const HeaderHome = () => {
  return (
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="#">
            <img src="https://reactjs.org/logo-og.png" alt="react logo" style={{ width: '50px',height:"50px" }}/>
        </a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarText">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="/">Vehículos </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="maintenance">Mantenimiento</a>
                </li>
            </ul>
        </div>
    </nav>
  )
}
