package co.edu.uniquindio.inmobiliaria.repositories;

import co.edu.uniquindio.inmobiliaria.dto.RealEstateDTO;
import co.edu.uniquindio.inmobiliaria.entities.RealEstateStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RealEstateRepository {
    private final JdbcTemplate jdbcTemplate;
    private final ProjectRepository projectRepository;

    public RealEstateRepository(JdbcTemplate jdbcTemplate, ProjectRepository projectRepository) {
        this.jdbcTemplate = jdbcTemplate;
        this.projectRepository = projectRepository;
    }

    public List<RealEstateDTO> findAll() {
        String sql = "SELECT id, nomenclature, private_area, built_area, value_per_square_meter, status, project_id FROM RealEstate";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            RealEstateDTO realEstate = new RealEstateDTO();
            realEstate.setId(rs.getInt("id"));
            realEstate.setNomenclature(rs.getString("nomenclature"));
            realEstate.setPrivateArea(rs.getDouble("private_area"));
            realEstate.setBuiltArea(rs.getDouble("built_area"));
            realEstate.setValuePerSquareMeter(rs.getDouble("value_per_square_meter"));
            realEstate.setStatus(RealEstateStatus.valueOf(rs.getString("status")));
            realEstate.setProject(projectRepository.findById(rs.getInt("project_id")));
            return realEstate;
        });
    }

    public RealEstateDTO findById(Integer id) {
        String sql = "SELECT id, nomenclature, private_area, built_area, value_per_square_meter, status, project_id FROM RealEstate WHERE id = ?";
        List<RealEstateDTO> result = jdbcTemplate.query(sql, new Object[]{id}, (rs, rowNum) -> {
            RealEstateDTO realEstate = new RealEstateDTO();
            realEstate.setId(rs.getInt("id"));
            realEstate.setNomenclature(rs.getString("nomenclature"));
            realEstate.setPrivateArea(rs.getDouble("private_area"));
            realEstate.setBuiltArea(rs.getDouble("built_area"));
            realEstate.setValuePerSquareMeter(rs.getDouble("value_per_square_meter"));
            realEstate.setStatus(RealEstateStatus.valueOf(rs.getString("status")));
            realEstate.setProject(projectRepository.findById(rs.getInt("project_id")));
            return realEstate;
        });
        return result.isEmpty() ? null : result.get(0);
    }

    public void save(RealEstateDTO realEstate) {
        String sql = "INSERT INTO RealEstate (nomenclature, private_area, built_area, value_per_square_meter, status, project_id) VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, realEstate.getNomenclature(), realEstate.getPrivateArea(), realEstate.getBuiltArea(), realEstate.getValuePerSquareMeter(), realEstate.getStatus().toString(), realEstate.getProject().getId());
    }

    public void update(Integer id, RealEstateDTO realEstate) {
        String sql = "UPDATE RealEstate SET nomenclature = ?, private_area = ?, built_area = ?, value_per_square_meter = ?, status = ?, project_id = ? WHERE id = ?";
        jdbcTemplate.update(sql, realEstate.getNomenclature(), realEstate.getPrivateArea(), realEstate.getBuiltArea(), realEstate.getValuePerSquareMeter(), realEstate.getStatus().toString(), realEstate.getProject().getId(), id);
    }

    public void delete(Integer id) {
        String sql = "DELETE FROM RealEstate WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
