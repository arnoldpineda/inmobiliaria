package co.edu.uniquindio.inmobiliaria.services.interfaces;

import co.edu.uniquindio.inmobiliaria.dto.FeeDTO;

import java.util.List;

public interface FeeService {
    List<FeeDTO> getAllFees();
    FeeDTO getFeeById(Integer id);
    void createFee(FeeDTO fee);
    void updateFee(Integer id, FeeDTO fee);
    void deleteFee(Integer id);
}
