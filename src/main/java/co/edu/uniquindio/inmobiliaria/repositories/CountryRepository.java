package co.edu.uniquindio.inmobiliaria.repositories;

import co.edu.uniquindio.inmobiliaria.dto.CountryDTO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CountryRepository {
    private final JdbcTemplate jdbcTemplate;

    public CountryRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<CountryDTO> findAll() {
        String sql = "SELECT id, name FROM Country";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            CountryDTO country = new CountryDTO();
            country.setId(rs.getInt("id"));
            country.setName(rs.getString("name"));
            return country;
        });
    }

    public CountryDTO findById(Integer id) {
        String sql = "SELECT id, name FROM Country WHERE id = ?";
        List<CountryDTO> result = jdbcTemplate.query(sql, new Object[]{id}, (rs, rowNum) -> {
            CountryDTO country = new CountryDTO();
            country.setId(rs.getInt("id"));
            country.setName(rs.getString("name"));
            return country;
        });
        return result.isEmpty() ? null : result.get(0);
    }

    public void save(CountryDTO country) {
        String sql = "INSERT INTO Country (name) VALUES (?)";
        jdbcTemplate.update(sql, country.getName());
    }

    public void update(Integer id, CountryDTO country) {
        String sql = "UPDATE Country SET name = ? WHERE id = ?";
        jdbcTemplate.update(sql, country.getName(), id);
    }

    public void delete(Integer id) {
        String sql = "DELETE FROM Country WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
