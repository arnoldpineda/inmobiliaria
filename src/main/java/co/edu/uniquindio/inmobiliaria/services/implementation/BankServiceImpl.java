package co.edu.uniquindio.inmobiliaria.services.implementation;

import co.edu.uniquindio.inmobiliaria.dto.BankDTO;
import co.edu.uniquindio.inmobiliaria.repositories.BankRepository;
import co.edu.uniquindio.inmobiliaria.services.interfaces.BankService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BankServiceImpl implements BankService {
    private final BankRepository bankRepository;

    public BankServiceImpl(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }

    @Override
    public List<BankDTO> getAllBanks() {
        return bankRepository.findAll();
    }

    @Override
    public BankDTO getBankById(Integer id) {
        return bankRepository.findById(id);
    }

    @Override
    public void createBank(BankDTO bank) {
        bankRepository.save(bank);
    }

    @Override
    public void updateBank(Integer id, BankDTO bank) {
        bankRepository.update(id, bank);
    }

    @Override
    public void deleteBank(Integer id) {
        bankRepository.delete(id);
    }
}
