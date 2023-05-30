package co.edu.uniquindio.inmobiliaria.services.interfaces;

import co.edu.uniquindio.inmobiliaria.dto.ProvinceDTO;

import java.util.List;

public interface ProvinceService {
    List<ProvinceDTO> getAllProvinces();
    ProvinceDTO getProvinceById(Integer id);
    void createProvince(ProvinceDTO province);
    void updateProvince(Integer id, ProvinceDTO province);
    void deleteProvince(Integer id);
}
