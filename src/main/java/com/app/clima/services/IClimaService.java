package com.app.clima.services;

import com.app.clima.entities.Clima;

public interface IClimaService {
    Clima getClima(String ciudad);
}
