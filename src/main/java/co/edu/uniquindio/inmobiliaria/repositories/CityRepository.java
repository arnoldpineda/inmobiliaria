package co.edu.uniquindio.inmobiliaria.repositories;

import co.edu.uniquindio.inmobiliaria.dto.CityDTO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CityRepository {
    private final JdbcTemplate jdbcTemplate;

    public CityRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<CityDTO> findAll() {
        String sql = "SELECT id, name FROM City";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            CityDTO city = new CityDTO();
            city.setId(rs.getInt("id"));
            city.setName(rs.getString("name"));
            return city;
        });
    }

    public CityDTO findById(Integer id) {
        String sql = "SELECT id, name FROM City WHERE id = ?";
        List<CityDTO> result = jdbcTemplate.query(sql, new Object[]{id}, (rs, rowNum) -> {
            CityDTO city = new CityDTO();
            city.setId(rs.getInt("id"));
            city.setName(rs.getString("name"));
            return city;
        });
        return result.isEmpty() ? null : result.get(0);
    }

    public void save(CityDTO city) {
        String sql = "INSERT INTO City (name) VALUES (?)";
        jdbcTemplate.update(sql, city.getName());
    }

    public void update(Integer id, CityDTO city) {
        String sql = "UPDATE City SET name = ? WHERE id = ?";
        jdbcTemplate.update(sql, city.getName(), id);
    }

    public void delete(Integer id) {
        String sql = "DELETE FROM City WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
