package co.edu.uniquindio.inmobiliaria.repositories;

import co.edu.uniquindio.inmobiliaria.dto.CustomerDTO;
import co.edu.uniquindio.inmobiliaria.dto.PhoneDTO;
import co.edu.uniquindio.inmobiliaria.entities.CustomerStatus;
import org.jetbrains.annotations.NotNull;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerRepository {
    private final JdbcTemplate jdbcTemplate;
    private final CityRepository cityRepository;
    private final PhoneRepository phoneRepository;

    public CustomerRepository(JdbcTemplate jdbcTemplate, CityRepository cityRepository, PhoneRepository phoneRepository) {
        this.jdbcTemplate = jdbcTemplate;
        this.cityRepository = cityRepository;
        this.phoneRepository = phoneRepository;
    }

    public List<CustomerDTO> findAll() {
        String sql = "SELECT id, name, address, status, city_id FROM Customer";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            CustomerDTO customer = new CustomerDTO();
            customer.setId(rs.getInt("id"));
            customer.setName(rs.getString("name"));
            customer.setAddress(rs.getString("address"));
            customer.setStatus(CustomerStatus.valueOf(rs.getString("status")));
            customer.setCity(cityRepository.findById(rs.getInt("city_id")));
            customer.setPhones(phoneRepository.findAllByCustomerId(rs.getInt("id")));
            return customer;
        });
    }

    public CustomerDTO findById(Integer id) {
        String sql = "SELECT id, name, address, status, city_id FROM Customer WHERE id = ?";
        List<CustomerDTO> result = jdbcTemplate.query(sql, new Object[]{id}, (rs, rowNum) -> {
            CustomerDTO customer = new CustomerDTO();
            customer.setId(rs.getInt("id"));
            customer.setName(rs.getString("name"));
            customer.setAddress(rs.getString("address"));
            customer.setStatus(CustomerStatus.valueOf(rs.getString("status")));
            customer.setCity(cityRepository.findById(rs.getInt("city_id")));
            customer.setPhones(phoneRepository.findAllByCustomerId(rs.getInt("id")));
            return customer;
        });
        return result.isEmpty() ? null : result.get(0);
    }

    public void save(CustomerDTO customer) {
        String sql = "INSERT INTO Customer (name, address, status, city_id) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, customer.getName(), customer.getAddress(), customer.getStatus().name(), customer.getCity().getId());
        Integer customerId = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        customer.setId(customerId);
        savePhonesForCustomer(customer);
    }

    public void update(Integer id, CustomerDTO customer) {
        String sql = "UPDATE Customer SET name = ?, address = ?, status = ?, city_id = ? WHERE id = ?";
        jdbcTemplate.update(sql, customer.getName(), customer.getAddress(), customer.getStatus().name(), customer.getCity().getId(), id);
        deletePhonesForCustomer(id);
        savePhonesForCustomer(customer);
    }

    public void delete(Integer id) {
        deletePhonesForCustomer(id);
        String sql = "DELETE FROM Customer WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    public void savePhonesForCustomer(@NotNull CustomerDTO customer) {
        for (PhoneDTO phone : customer.getPhones()) {
            phoneRepository.save(phone);
        }
    }

    public void deletePhonesForCustomer(Integer customerId) {
        phoneRepository.deleteByCustomerId(customerId);
    }
}
