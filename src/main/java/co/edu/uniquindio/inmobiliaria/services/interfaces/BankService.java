package co.edu.uniquindio.inmobiliaria.services.interfaces;

import co.edu.uniquindio.inmobiliaria.dto.BankDTO;

import java.util.List;

public interface BankService {
    List<BankDTO> getAllBanks();
    BankDTO getBankById(Integer id);
    void createBank(BankDTO bank);
    void updateBank(Integer id, BankDTO bank);
    void deleteBank(Integer id);
}
