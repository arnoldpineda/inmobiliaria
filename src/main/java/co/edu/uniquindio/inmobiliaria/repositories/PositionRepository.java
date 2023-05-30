package co.edu.uniquindio.inmobiliaria.repositories;

import co.edu.uniquindio.inmobiliaria.dto.PositionDTO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PositionRepository {
    private final JdbcTemplate jdbcTemplate;

    public PositionRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<PositionDTO> findAll() {
        String sql = "SELECT id, name FROM Position";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            PositionDTO position = new PositionDTO();
            position.setId(rs.getInt("id"));
            position.setName(rs.getString("name"));
            return position;
        });
    }

    public PositionDTO findById(Integer id) {
        String sql = "SELECT id, name FROM Position WHERE id = ?";
        List<PositionDTO> result = jdbcTemplate.query(sql, new Object[]{id}, (rs, rowNum) -> {
            PositionDTO position = new PositionDTO();
            position.setId(rs.getInt("id"));
            position.setName(rs.getString("name"));
            return position;
        });
        return result.isEmpty() ? null : result.get(0);
    }

    public void save(PositionDTO position) {
        String sql = "INSERT INTO Position (name) VALUES (?)";
        jdbcTemplate.update(sql, position.getName());
    }

    public void update(Integer id, PositionDTO position) {
        String sql = "UPDATE Position SET name = ? WHERE id = ?";
        jdbcTemplate.update(sql, position.getName(), id);
    }

    public void delete(Integer id) {
        String sql = "DELETE FROM Position WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
