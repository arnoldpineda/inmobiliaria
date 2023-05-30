package co.edu.uniquindio.inmobiliaria.services.interfaces;

import co.edu.uniquindio.inmobiliaria.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {
    List<EmployeeDTO> findAll();
    EmployeeDTO findById(Integer id);
    void save(EmployeeDTO employee);
    void update(Integer id, EmployeeDTO employee);
    void delete(Integer id);
}
