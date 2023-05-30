package co.edu.uniquindio.inmobiliaria.services.interfaces;

import co.edu.uniquindio.inmobiliaria.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {
    List<CustomerDTO> getAllCustomers();
    CustomerDTO getCustomerById(Integer id);
    void createCustomer(CustomerDTO customer);
    void updateCustomer(Integer id, CustomerDTO customer);
    void deleteCustomer(Integer id);
}
