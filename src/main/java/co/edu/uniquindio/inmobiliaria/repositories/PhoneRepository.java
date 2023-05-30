package co.edu.uniquindio.inmobiliaria.repositories;

import co.edu.uniquindio.inmobiliaria.dto.CustomerDTO;
import co.edu.uniquindio.inmobiliaria.dto.PhoneDTO;
import org.jetbrains.annotations.NotNull;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PhoneRepository {
    private final JdbcTemplate jdbcTemplate;
    private final CustomerRepository customerRepository;

    public PhoneRepository(JdbcTemplate jdbcTemplate, CustomerRepository customerRepository) {
        this.jdbcTemplate = jdbcTemplate;
        this.customerRepository = customerRepository;
    }

    public List<PhoneDTO> findAll() {
        String sql = "SELECT id, number, customer_id FROM Phone";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            PhoneDTO phone = new PhoneDTO();
            phone.setId(rs.getInt("id"));
            phone.setNumber(rs.getString("number"));
            phone.setCustomer(customerRepository.findById(rs.getInt("customer_id")));
            return phone;
        });
    }

    public PhoneDTO findById(Integer id) {
        String sql = "SELECT id, number, customer_id FROM Phone WHERE id = ?";
        List<PhoneDTO> result = jdbcTemplate.query(sql, new Object[]{id}, (rs, rowNum) -> {
            PhoneDTO phone = new PhoneDTO();
            phone.setId(rs.getInt("id"));
            phone.setNumber(rs.getString("number"));
            phone.setCustomer(customerRepository.findById(rs.getInt("customer_id")));
            return phone;
        });
        return result.isEmpty() ? null : result.get(0);
    }

    public void save(PhoneDTO phone) {
        String sql = "INSERT INTO Phone (number, customer_id) VALUES (?, ?)";
        jdbcTemplate.update(sql, phone.getNumber(), phone.getCustomer().getId());
    }

    public void update(Integer id, PhoneDTO phone) {
        String sql = "UPDATE Phone SET number = ?, customer_id = ? WHERE id = ?";
        jdbcTemplate.update(sql, phone.getNumber(), phone.getCustomer().getId(), id);
    }

    public void delete(Integer id) {
        String sql = "DELETE FROM Phone WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    public List<PhoneDTO> findAllByCustomerId(Integer customerId) {
        String sql = "SELECT id, number FROM Phone WHERE customer_id = ?";
        return jdbcTemplate.query(sql, new Object[]{customerId}, (rs, rowNum) -> {
            PhoneDTO phone = new PhoneDTO();
            phone.setId(rs.getInt("id"));
            phone.setNumber(rs.getString("number"));
            return phone;
        });
    }

    public PhoneDTO findByCustomerId(Integer customerId) {
        String sql = "SELECT id, number FROM Phone WHERE customer_id = ?";
        List<PhoneDTO> result = jdbcTemplate.query(sql, new Object[]{customerId}, (rs, rowNum) -> {
            PhoneDTO phone = new PhoneDTO();
            phone.setId(rs.getInt("id"));
            phone.setNumber(rs.getString("number"));
            return phone;
        });
        return result.isEmpty() ? null : result.get(0);
    }

    public void deleteByCustomerId(Integer customerId) {
        String sql = "DELETE FROM Phone WHERE customer_id = ?";
        jdbcTemplate.update(sql, customerId);
    }
}
