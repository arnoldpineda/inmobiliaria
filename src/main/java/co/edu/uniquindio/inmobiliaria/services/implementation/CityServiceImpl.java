package co.edu.uniquindio.inmobiliaria.services.implementation;

import co.edu.uniquindio.inmobiliaria.dto.CityDTO;
import co.edu.uniquindio.inmobiliaria.repositories.CityRepository;
import co.edu.uniquindio.inmobiliaria.services.interfaces.CityService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CityServiceImpl implements CityService {
    private final CityRepository cityRepository;

    public CityServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public List<CityDTO> getAllCities() {
        return cityRepository.findAll();
    }

    @Override
    public CityDTO getCityById(Integer id) {
        return cityRepository.findById(id);
    }

    @Override
    public void createCity(CityDTO city) {
        cityRepository.save(city);
    }

    @Override
    public void updateCity(Integer id, CityDTO city) {
        cityRepository.update(id, city);
    }

    @Override
    public void deleteCity(Integer id) {
        cityRepository.delete(id);
    }
}
