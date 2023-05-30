package co.edu.uniquindio.inmobiliaria.services.implementation;

import co.edu.uniquindio.inmobiliaria.dto.EmployeeDTO;
import co.edu.uniquindio.inmobiliaria.repositories.EmployeeRepository;
import co.edu.uniquindio.inmobiliaria.services.interfaces.EmployeeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<EmployeeDTO> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public EmployeeDTO findById(Integer id) {
        return employeeRepository.findById(id);
    }

    @Override
    public void save(EmployeeDTO employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void update(Integer id, EmployeeDTO employee) {
        employeeRepository.update(id, employee);
    }

    @Override
    public void delete(Integer id) {
        employeeRepository.delete(id);
    }
}
