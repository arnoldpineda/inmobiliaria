package co.edu.uniquindio.inmobiliaria.repositories;

import co.edu.uniquindio.inmobiliaria.dto.ProvinceDTO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProvinceRepository {
    private final JdbcTemplate jdbcTemplate;

    public ProvinceRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<ProvinceDTO> findAll() {
        String sql = "SELECT id, name FROM Province";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            ProvinceDTO province = new ProvinceDTO();
            province.setId(rs.getInt("id"));
            province.setName(rs.getString("name"));
            return province;
        });
    }

    public ProvinceDTO findById(Integer id) {
        String sql = "SELECT id, name FROM Province WHERE id = ?";
        List<ProvinceDTO> result = jdbcTemplate.query(sql, new Object[]{id}, (rs, rowNum) -> {
            ProvinceDTO province = new ProvinceDTO();
            province.setId(rs.getInt("id"));
            province.setName(rs.getString("name"));
            return province;
        });
        return result.isEmpty() ? null : result.get(0);
    }

    public void save(ProvinceDTO province) {
        String sql = "INSERT INTO Province (name) VALUES (?)";
        jdbcTemplate.update(sql, province.getName());
    }

    public void update(Integer id, ProvinceDTO province) {
        String sql = "UPDATE Province SET name = ? WHERE id = ?";
        jdbcTemplate.update(sql, province.getName(), id);
    }

    public void delete(Integer id) {
        String sql = "DELETE FROM Province WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
