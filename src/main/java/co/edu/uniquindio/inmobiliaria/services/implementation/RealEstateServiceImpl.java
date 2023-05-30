package co.edu.uniquindio.inmobiliaria.services;

import co.edu.uniquindio.inmobiliaria.dto.RealEstateDTO;
import co.edu.uniquindio.inmobiliaria.repositories.RealEstateRepository;
import co.edu.uniquindio.inmobiliaria.services.interfaces.RealEstateService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RealEstateServiceImpl implements RealEstateService {
    private final RealEstateRepository realEstateRepository;

    public RealEstateServiceImpl(RealEstateRepository realEstateRepository) {
        this.realEstateRepository = realEstateRepository;
    }

    @Override
    public List<RealEstateDTO> getAllRealEstates() {
        return realEstateRepository.findAll();
    }

    @Override
    public RealEstateDTO getRealEstateById(Integer id) {
        return realEstateRepository.findById(id);
    }

    @Override
    public void createRealEstate(RealEstateDTO realEstate) {
        realEstateRepository.save(realEstate);
    }

    @Override
    public void updateRealEstate(Integer id, RealEstateDTO realEstate) {
        realEstateRepository.update(id, realEstate);
    }

    @Override
    public void deleteRealEstate(Integer id) {
        realEstateRepository.delete(id);
    }
}
