package co.edu.uniquindio.inmobiliaria.repositories;

import co.edu.uniquindio.inmobiliaria.dto.BankDTO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BankRepository {
    private final JdbcTemplate jdbcTemplate;

    public BankRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<BankDTO> findAll() {
        String sql = "SELECT id, name, phone, email FROM Bank";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            BankDTO bank = new BankDTO();
            bank.setId(rs.getInt("id"));
            bank.setName(rs.getString("name"));
            bank.setPhone(rs.getString("phone"));
            bank.setEmail(rs.getString("email"));
            return bank;
        });
    }

    public BankDTO findById(Integer id) {
        String sql = "SELECT id, name, phone, email FROM Bank WHERE id = ?";
        List<BankDTO> result = jdbcTemplate.query(sql, new Object[]{id}, (rs, rowNum) -> {
            BankDTO bank = new BankDTO();
            bank.setId(rs.getInt("id"));
            bank.setName(rs.getString("name"));
            bank.setPhone(rs.getString("phone"));
            bank.setEmail(rs.getString("email"));
            return bank;
        });
        return result.isEmpty() ? null : result.get(0);
    }

    public void save(BankDTO bank) {
        String sql = "INSERT INTO Bank (name, phone, email) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, bank.getName(), bank.getPhone(), bank.getEmail());
    }

    public void update(Integer id, BankDTO bank) {
        String sql = "UPDATE Bank SET name = ?, phone = ?, email = ? WHERE id = ?";
        jdbcTemplate.update(sql, bank.getName(), bank.getPhone(), bank.getEmail(), id);
    }

    public void delete(Integer id) {
        String sql = "DELETE FROM Bank WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
