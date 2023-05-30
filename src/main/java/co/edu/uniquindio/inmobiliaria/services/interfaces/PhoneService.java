package co.edu.uniquindio.inmobiliaria.services.interfaces;

import co.edu.uniquindio.inmobiliaria.dto.PhoneDTO;

import java.util.List;

public interface PhoneService {
    List<PhoneDTO> getAllPhones();
    PhoneDTO getPhoneById(Integer id);
    void createPhone(PhoneDTO phone);
    void updatePhone(Integer id, PhoneDTO phone);
    void deletePhone(Integer id);
}
