package co.edu.uniquindio.inmobiliaria.repositories;

import co.edu.uniquindio.inmobiliaria.dto.CityDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CityRepository {
    private final JdbcTemplate jdbcTemplate;
    private final ProvinceRepository provinceRepository;

    @Autowired
    public CityRepository(JdbcTemplate jdbcTemplate, ProvinceRepository provinceRepository) {
        this.jdbcTemplate = jdbcTemplate;
        this.provinceRepository = provinceRepository;
    }

    public List<CityDTO> findAll() {
        String sql = "SELECT id, name, province_id FROM City";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            CityDTO city = new CityDTO();
            city.setId(rs.getInt("id"));
            city.setName(rs.getString("name"));
            city.setProvince(provinceRepository.findById(rs.getInt("province_id")));
            return city;
        });
    }

    public CityDTO findById(Integer id) {
        String sql = "SELECT id, name, province_id FROM City WHERE id = ?";
        List<CityDTO> result = jdbcTemplate.query(sql, new Object[]{id}, (rs, rowNum) -> {
            CityDTO city = new CityDTO();
            city.setId(rs.getInt("id"));
            city.setName(rs.getString("name"));
            city.setProvince(provinceRepository.findById(rs.getInt("province_id")));
            return city;
        });
        return result.isEmpty() ? null : result.get(0);
    }

    public void save(CityDTO city) {
        String sql = "INSERT INTO City (name, province_id) VALUES (?, ?)";
        jdbcTemplate.update(sql, city.getName(), city.getProvince().getId());
    }

    public void update(Integer id, CityDTO city) {
        String sql = "UPDATE City SET name = ?, province_id = ? WHERE id = ?";
        jdbcTemplate.update(sql, city.getName(), city.getProvince().getId(), id);
    }

    public void delete(Integer id) {
        String sql = "DELETE FROM City WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
