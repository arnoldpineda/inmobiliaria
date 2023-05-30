package co.edu.uniquindio.inmobiliaria.services.interfaces;

import co.edu.uniquindio.inmobiliaria.dto.CityDTO;

import java.util.List;

public interface CityService {
    List<CityDTO> getAllCities();
    CityDTO getCityById(Integer id);
    void createCity(CityDTO city);
    void updateCity(Integer id, CityDTO city);
    void deleteCity(Integer id);
}
