package co.edu.uniquindio.inmobiliaria.services.interfaces;

import co.edu.uniquindio.inmobiliaria.dto.CountryDTO;

import java.util.List;

public interface CountryService {
    List<CountryDTO> getAllCountries();
    CountryDTO getCountryById(Integer id);
    void createCountry(CountryDTO country);
    void updateCountry(Integer id, CountryDTO country);
    void deleteCountry(Integer id);
}
