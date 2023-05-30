package co.edu.uniquindio.inmobiliaria.services.implementation;

import co.edu.uniquindio.inmobiliaria.dto.ProvinceDTO;
import co.edu.uniquindio.inmobiliaria.repositories.ProvinceRepository;
import co.edu.uniquindio.inmobiliaria.services.interfaces.ProvinceService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProvinceServiceImpl implements ProvinceService {
    private final ProvinceRepository provinceRepository;

    public ProvinceServiceImpl(ProvinceRepository provinceRepository) {
        this.provinceRepository = provinceRepository;
    }

    @Override
    public List<ProvinceDTO> getAllProvinces() {
        return provinceRepository.findAll();
    }

    @Override
    public ProvinceDTO getProvinceById(Integer id) {
        return provinceRepository.findById(id);
    }

    @Override
    public void createProvince(ProvinceDTO province) {
        provinceRepository.save(province);
    }

    @Override
    public void updateProvince(Integer id, ProvinceDTO province) {
        provinceRepository.update(id, province);
    }

    @Override
    public void deleteProvince(Integer id) {
        provinceRepository.delete(id);
    }
}
