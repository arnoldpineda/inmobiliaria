package co.edu.uniquindio.inmobiliaria.repositories;

import co.edu.uniquindio.inmobiliaria.dto.BillDTO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BillRepository {
    private final JdbcTemplate jdbcTemplate;
    private final CustomerRepository customerRepository;
    private final RealEstateRepository realEstateRepository;

    public BillRepository(JdbcTemplate jdbcTemplate, CustomerRepository customerRepository, RealEstateRepository realEstateRepository) {
        this.jdbcTemplate = jdbcTemplate;
        this.customerRepository = customerRepository;
        this.realEstateRepository = realEstateRepository;
    }

    public List<BillDTO> findAll() {
        String sql = "SELECT id, value, date, customer_id, real_estate_id FROM Bill";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            BillDTO bill = new BillDTO();
            bill.setId(rs.getInt("id"));
            bill.setValue(rs.getDouble("value"));
            bill.setDate(rs.getTimestamp("date").toLocalDateTime());
            // Set the customer and real estate details using their respective repositories
            bill.setCustomer(customerRepository.findById(rs.getInt("customer_id")));
            bill.setRealEstate(realEstateRepository.findById(rs.getInt("real_estate_id")));
            return bill;
        });
    }

    public BillDTO findById(Integer id) {
        String sql = "SELECT id, value, date, customer_id, real_estate_id FROM Bill WHERE id = ?";
        List<BillDTO> result = jdbcTemplate.query(sql, new Object[]{id}, (rs, rowNum) -> {
            BillDTO bill = new BillDTO();
            bill.setId(rs.getInt("id"));
            bill.setValue(rs.getDouble("value"));
            bill.setDate(rs.getTimestamp("date").toLocalDateTime());
            // Set the customer and real estate details using their respective repositories
            bill.setCustomer(customerRepository.findById(rs.getInt("customer_id")));
            bill.setRealEstate(realEstateRepository.findById(rs.getInt("real_estate_id")));
            return bill;
        });
        return result.isEmpty() ? null : result.get(0);
    }

    public void save(BillDTO bill) {
        String sql = "INSERT INTO Bill (value, date, customer_id, real_estate_id) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, bill.getValue(), bill.getDate(), bill.getCustomer().getId(), bill.getRealEstate().getId());
        Integer billId = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        bill.setId(billId);
    }

    public void update(Integer id, BillDTO bill) {
        String sql = "UPDATE Bill SET value = ?, date = ?, customer_id = ?, real_estate_id = ? WHERE id = ?";
        jdbcTemplate.update(sql, bill.getValue(), bill.getDate(), bill.getCustomer().getId(), bill.getRealEstate().getId(), id);
    }

    public void delete(Integer id) {
        String sql = "DELETE FROM Bill WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
