package co.edu.uniquindio.inmobiliaria.repositories;

import co.edu.uniquindio.inmobiliaria.dto.FeeDTO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FeeRepository {
    private final JdbcTemplate jdbcTemplate;
    private final SalesPromiseRepository salesPromiseRepository;
    private final PaymentRepository paymentRepository;

    public FeeRepository(JdbcTemplate jdbcTemplate, SalesPromiseRepository salesPromiseRepository, PaymentRepository paymentRepository) {
        this.jdbcTemplate = jdbcTemplate;
        this.salesPromiseRepository = salesPromiseRepository;
        this.paymentRepository = paymentRepository;
    }

    public List<FeeDTO> findAll() {
        String sql = "SELECT id, date, value, sales_promise_id, payment_id FROM Fee";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            FeeDTO fee = new FeeDTO();
            fee.setId(rs.getInt("id"));
            fee.setDate(rs.getTimestamp("date").toLocalDateTime());
            fee.setValue(rs.getDouble("value"));
            fee.setSalesPromise(salesPromiseRepository.findById(rs.getInt("sales_promise_id")));
            fee.setPayment(paymentRepository.findById(rs.getInt("payment_id")));
            return fee;
        });
    }

    public FeeDTO findById(Integer id) {
        String sql = "SELECT id, date, value, sales_promise_id, payment_id FROM Fee WHERE id = ?";
        List<FeeDTO> result = jdbcTemplate.query(sql, new Object[]{id}, (rs, rowNum) -> {
            FeeDTO fee = new FeeDTO();
            fee.setId(rs.getInt("id"));
            fee.setDate(rs.getTimestamp("date").toLocalDateTime());
            fee.setValue(rs.getDouble("value"));
            fee.setSalesPromise(salesPromiseRepository.findById(rs.getInt("sales_promise_id")));
            fee.setPayment(paymentRepository.findById(rs.getInt("payment_id")));
            return fee;
        });
        return result.isEmpty() ? null : result.get(0);
    }

    public void save(FeeDTO fee) {
        String sql = "INSERT INTO Fee (date, value, sales_promise_id, payment_id) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, fee.getDate(), fee.getValue(), fee.getSalesPromise().getId(), fee.getPayment().getId());
    }

    public void update(Integer id, FeeDTO fee) {
        String sql = "UPDATE Fee SET date = ?, value = ?, sales_promise_id = ?, payment_id = ? WHERE id = ?";
        jdbcTemplate.update(sql, fee.getDate(), fee.getValue(), fee.getSalesPromise().getId(), fee.getPayment().getId(), id);
    }

    public void delete(Integer id) {
        String sql = "DELETE FROM Fee WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
