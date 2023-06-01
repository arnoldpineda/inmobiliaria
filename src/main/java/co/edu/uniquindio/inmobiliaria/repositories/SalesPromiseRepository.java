package co.edu.uniquindio.inmobiliaria.repositories;

import co.edu.uniquindio.inmobiliaria.dto.SalesPromiseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SalesPromiseRepository {
    private final JdbcTemplate jdbcTemplate;
    private final BankRepository bankRepository;
    private final EmployeeRepository employeeRepository;
    private final CustomerRepository customerRepository;
    private final RealEstateRepository realEstateRepository;

    @Autowired
    public SalesPromiseRepository(JdbcTemplate jdbcTemplate, BankRepository bankRepository, EmployeeRepository employeeRepository, CustomerRepository customerRepository, RealEstateRepository realEstateRepository) {
        this.jdbcTemplate = jdbcTemplate;
        this.bankRepository = bankRepository;
        this.employeeRepository = employeeRepository;
        this.customerRepository = customerRepository;
        this.realEstateRepository = realEstateRepository;
    }

    public List<SalesPromiseDTO> findAll() {
        String sql = "SELECT id, sale_date, sale_value, real_estate_number, credit, credit_disbursement_date, credit_value, bank_id, agent_id, customer_id, real_estate_id FROM SalesPromise";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            SalesPromiseDTO salesPromise = new SalesPromiseDTO();
            salesPromise.setId(rs.getInt("id"));
            salesPromise.setSaleDate(rs.getTimestamp("sale_date").toLocalDateTime());
            salesPromise.setSaleValue(rs.getDouble("sale_value"));
            salesPromise.setRealEstateNumber(rs.getInt("real_estate_number"));
            salesPromise.setCredit(rs.getBoolean("credit"));
            salesPromise.setCreditDisbursementDate(rs.getTimestamp("credit_disbursement_date").toLocalDateTime());
            salesPromise.setCreditValue(rs.getDouble("credit_value"));
            salesPromise.setBank(bankRepository.findById(rs.getInt("bank_id")));
            salesPromise.setAgent(employeeRepository.findById(rs.getInt("agent_id")));
            salesPromise.setCustomer(customerRepository.findById(rs.getInt("customer_id")));
            salesPromise.setRealEstate(realEstateRepository.findById(rs.getInt("real_estate_id")));
            return salesPromise;
        });
    }

    public SalesPromiseDTO findById(Integer id) {
        String sql = "SELECT id, sale_date, sale_value, real_estate_number, credit, credit_disbursement_date, credit_value, bank_id, agent_id, customer_id, real_estate_id FROM SalesPromise WHERE id = ?";
        List<SalesPromiseDTO> result = jdbcTemplate.query(sql, new Object[]{id}, (rs, rowNum) -> {
            SalesPromiseDTO salesPromise = new SalesPromiseDTO();
            salesPromise.setId(rs.getInt("id"));
            salesPromise.setSaleDate(rs.getTimestamp("sale_date").toLocalDateTime());
            salesPromise.setSaleValue(rs.getDouble("sale_value"));
            salesPromise.setRealEstateNumber(rs.getInt("real_estate_number"));
            salesPromise.setCredit(rs.getBoolean("credit"));
            salesPromise.setCreditDisbursementDate(rs.getTimestamp("credit_disbursement_date").toLocalDateTime());
            salesPromise.setCreditValue(rs.getDouble("credit_value"));
            salesPromise.setBank(bankRepository.findById(rs.getInt("bank_id")));
            salesPromise.setAgent(employeeRepository.findById(rs.getInt("agent_id")));
            salesPromise.setCustomer(customerRepository.findById(rs.getInt("customer_id")));
            salesPromise.setRealEstate(realEstateRepository.findById(rs.getInt("real_estate_id")));
            return salesPromise;
        });
        return result.isEmpty() ? null : result.get(0);
    }

    public void save(SalesPromiseDTO salesPromise) {
        String sql = "INSERT INTO SalesPromise (sale_date, sale_value, real_estate_number, credit, credit_disbursement_date, credit_value, bank_id, agent_id, customer_id, real_estate_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, salesPromise.getSaleDate(), salesPromise.getSaleValue(), salesPromise.getRealEstateNumber(), salesPromise.getCredit(), salesPromise.getCreditDisbursementDate(), salesPromise.getCreditValue(), salesPromise.getBank().getId(), salesPromise.getAgent().getId(), salesPromise.getCustomer().getId(), salesPromise.getRealEstate().getId());
    }

    public void update(Integer id, SalesPromiseDTO salesPromise) {
        String sql = "UPDATE SalesPromise SET sale_date = ?, sale_value = ?, real_estate_number = ?, credit = ?, credit_disbursement_date = ?, credit_value = ?, bank_id = ?, agent_id = ?, customer_id = ?, real_estate_id = ? WHERE id = ?";
        jdbcTemplate.update(sql, salesPromise.getSaleDate(), salesPromise.getSaleValue(), salesPromise.getRealEstateNumber(), salesPromise.getCredit(), salesPromise.getCreditDisbursementDate(), salesPromise.getCreditValue(), salesPromise.getBank().getId(), salesPromise.getAgent().getId(), salesPromise.getCustomer().getId(), salesPromise.getRealEstate().getId(), id);
    }

    public void delete(Integer id) {
        String sql = "DELETE FROM SalesPromise WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
