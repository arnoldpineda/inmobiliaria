package co.edu.uniquindio.inmobiliaria.services.implementation;

import co.edu.uniquindio.inmobiliaria.dto.PhoneDTO;
import co.edu.uniquindio.inmobiliaria.repositories.PhoneRepository;
import co.edu.uniquindio.inmobiliaria.services.interfaces.PhoneService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PhoneServiceImpl implements PhoneService {
    private final PhoneRepository phoneRepository;

    public PhoneServiceImpl(PhoneRepository phoneRepository) {
        this.phoneRepository = phoneRepository;
    }

    @Override
    public List<PhoneDTO> getAllPhones() {
        return phoneRepository.findAll();
    }

    @Override
    public PhoneDTO getPhoneById(Integer id) {
        return phoneRepository.findById(id);
    }

    @Override
    public void createPhone(PhoneDTO phone) {
        phoneRepository.save(phone);
    }

    @Override
    public void updatePhone(Integer id, PhoneDTO phone) {
        phoneRepository.update(id, phone);
    }

    @Override
    public void deletePhone(Integer id) {
        phoneRepository.delete(id);
    }
}
