package co.edu.uniquindio.inmobiliaria.repositories;

import co.edu.uniquindio.inmobiliaria.dto.ProvinceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProvinceRepository {
    private final JdbcTemplate jdbcTemplate;
    private final CountryRepository countryRepository;

    @Autowired
    public ProvinceRepository(JdbcTemplate jdbcTemplate, CountryRepository countryRepository) {
        this.jdbcTemplate = jdbcTemplate;
        this.countryRepository = countryRepository;
    }

    public List<ProvinceDTO> findAll() {
        String sql = "SELECT id, name, country_id FROM Province";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            ProvinceDTO province = new ProvinceDTO();
            province.setId(rs.getInt("id"));
            province.setName(rs.getString("name"));
            province.setCountry(countryRepository.findById(rs.getInt("country_id")));
            return province;
        });
    }

    public ProvinceDTO findById(Integer id) {
        String sql = "SELECT id, name, country_id FROM Province WHERE id = ?";
        List<ProvinceDTO> result = jdbcTemplate.query(sql, new Object[]{id}, (rs, rowNum) -> {
            ProvinceDTO province = new ProvinceDTO();
            province.setId(rs.getInt("id"));
            province.setName(rs.getString("name"));
            province.setCountry(countryRepository.findById(rs.getInt("country_id")));
            return province;
        });
        return result.isEmpty() ? null : result.get(0);
    }

    public void save(ProvinceDTO province) {
        String sql = "INSERT INTO Province (name, country_id) VALUES (?, ?)";
        jdbcTemplate.update(sql, province.getName(), province.getCountry().getId());
    }

    public void update(Integer id, ProvinceDTO province) {
        String sql = "UPDATE Province SET name = ?, country_id = ? WHERE id = ?";
        jdbcTemplate.update(sql, province.getName(), province.getCountry().getId(), id);
    }

    public void delete(Integer id) {
        String sql = "DELETE FROM Province WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
