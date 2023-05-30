package co.edu.uniquindio.inmobiliaria.services.implementation;

import co.edu.uniquindio.inmobiliaria.dto.CustomerDTO;
import co.edu.uniquindio.inmobiliaria.repositories.CustomerRepository;
import co.edu.uniquindio.inmobiliaria.services.interfaces.CustomerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public CustomerDTO getCustomerById(Integer id) {
        return customerRepository.findById(id);
    }

    @Override
    public void createCustomer(CustomerDTO customer) {
        customerRepository.save(customer);
    }

    @Override
    public void updateCustomer(Integer id, CustomerDTO customer) {
        customerRepository.update(id, customer);
    }

    @Override
    public void deleteCustomer(Integer id) {
        customerRepository.delete(id);
    }
}
