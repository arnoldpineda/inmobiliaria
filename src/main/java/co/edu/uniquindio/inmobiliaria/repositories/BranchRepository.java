package co.edu.uniquindio.inmobiliaria.repositories;

import co.edu.uniquindio.inmobiliaria.dto.BranchDTO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BranchRepository {
    private final JdbcTemplate jdbcTemplate;
    private final CityRepository cityRepository;

    public BranchRepository(JdbcTemplate jdbcTemplate, CityRepository cityRepository) {
        this.jdbcTemplate = jdbcTemplate;
        this.cityRepository = cityRepository;
    }

    public List<BranchDTO> findAll() {
        String sql = "SELECT id, name, address, phone, city_id FROM Branch";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            BranchDTO branch = new BranchDTO();
            branch.setId(rs.getInt("id"));
            branch.setName(rs.getString("name"));
            branch.setAddress(rs.getString("address"));
            branch.setPhone(rs.getString("phone"));
            branch.setCity(cityRepository.findById(rs.getInt("city_id")));
            return branch;
        });
    }

    public BranchDTO findById(Integer id) {
        String sql = "SELECT id, name, address, phone, city_id FROM Branch WHERE id = ?";
        List<BranchDTO> result = jdbcTemplate.query(sql, new Object[]{id}, (rs, rowNum) -> {
            BranchDTO branch = new BranchDTO();
            branch.setId(rs.getInt("id"));
            branch.setName(rs.getString("name"));
            branch.setAddress(rs.getString("address"));
            branch.setPhone(rs.getString("phone"));
            branch.setCity(cityRepository.findById(rs.getInt("city_id")));
            return branch;
        });
        return result.isEmpty() ? null : result.get(0);
    }

    public void save(BranchDTO branch) {
        String sql = "INSERT INTO Branch (name, address, phone, city_id) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, branch.getName(), branch.getAddress(), branch.getPhone(), branch.getCity().getId());
    }

    public void update(Integer id, BranchDTO branch) {
        String sql = "UPDATE Branch SET name = ?, address = ?, phone = ?, city_id = ? WHERE id = ?";
        jdbcTemplate.update(sql, branch.getName(), branch.getAddress(), branch.getPhone(), branch.getCity().getId(), id);
    }

    public void delete(Integer id) {
        String sql = "DELETE FROM Branch WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
