package co.edu.uniquindio.inmobiliaria.services.interfaces;

import co.edu.uniquindio.inmobiliaria.dto.RealEstateDTO;

import java.util.List;

public interface RealEstateService {
    List<RealEstateDTO> getAllRealEstates();
    RealEstateDTO getRealEstateById(Integer id);
    void createRealEstate(RealEstateDTO realEstate);
    void updateRealEstate(Integer id, RealEstateDTO realEstate);
    void deleteRealEstate(Integer id);
}
