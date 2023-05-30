package co.edu.uniquindio.inmobiliaria.services.implementation;

import co.edu.uniquindio.inmobiliaria.dto.FeeDTO;
import co.edu.uniquindio.inmobiliaria.repositories.FeeRepository;
import co.edu.uniquindio.inmobiliaria.services.interfaces.FeeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FeeServiceImpl implements FeeService {
    private final FeeRepository feeRepository;

    public FeeServiceImpl(FeeRepository feeRepository) {
        this.feeRepository = feeRepository;
    }

    @Override
    public List<FeeDTO> getAllFees() {
        return feeRepository.findAll();
    }

    @Override
    public FeeDTO getFeeById(Integer id) {
        return feeRepository.findById(id);
    }

    @Override
    public void createFee(FeeDTO fee) {
        feeRepository.save(fee);
    }

    @Override
    public void updateFee(Integer id, FeeDTO fee) {
        feeRepository.update(id, fee);
    }

    @Override
    public void deleteFee(Integer id) {
        feeRepository.delete(id);
    }
}
