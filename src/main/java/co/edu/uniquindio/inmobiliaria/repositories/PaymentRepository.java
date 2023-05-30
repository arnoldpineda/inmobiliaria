package co.edu.uniquindio.inmobiliaria.repositories;

import co.edu.uniquindio.inmobiliaria.dto.PaymentDTO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PaymentRepository {
    private final JdbcTemplate jdbcTemplate;

    public PaymentRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<PaymentDTO> findAll() {
        String sql = "SELECT id, name FROM Payment";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            PaymentDTO payment = new PaymentDTO();
            payment.setId(rs.getInt("id"));
            payment.setName(rs.getString("name"));
            return payment;
        });
    }

    public PaymentDTO findById(Integer id) {
        String sql = "SELECT id, name FROM Payment WHERE id = ?";
        List<PaymentDTO> result = jdbcTemplate.query(sql, new Object[]{id}, (rs, rowNum) -> {
            PaymentDTO payment = new PaymentDTO();
            payment.setId(rs.getInt("id"));
            payment.setName(rs.getString("name"));
            return payment;
        });
        return result.isEmpty() ? null : result.get(0);
    }

    public void save(PaymentDTO payment) {
        String sql = "INSERT INTO Payment (name) VALUES (?)";
        jdbcTemplate.update(sql, payment.getName());
    }

    public void update(Integer id, PaymentDTO payment) {
        String sql = "UPDATE Payment SET name = ? WHERE id = ?";
        jdbcTemplate.update(sql, payment.getName(), id);
    }

    public void delete(Integer id) {
        String sql = "DELETE FROM Payment WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
