package co.edu.uniquindio.inmobiliaria.services.implementation;

import co.edu.uniquindio.inmobiliaria.dto.CountryDTO;
import co.edu.uniquindio.inmobiliaria.repositories.CountryRepository;
import co.edu.uniquindio.inmobiliaria.services.interfaces.CountryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CountryServiceImpl implements CountryService {
    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<CountryDTO> getAllCountries() {
        return countryRepository.findAll();
    }

    @Override
    public CountryDTO getCountryById(Integer id) {
        return countryRepository.findById(id);
    }

    @Override
    public void createCountry(CountryDTO country) {
        countryRepository.save(country);
    }

    @Override
    public void updateCountry(Integer id, CountryDTO country) {
        countryRepository.update(id, country);
    }

    @Override
    public void deleteCountry(Integer id) {
        countryRepository.delete(id);
    }
}
