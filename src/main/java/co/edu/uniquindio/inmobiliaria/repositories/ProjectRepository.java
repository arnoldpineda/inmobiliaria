package co.edu.uniquindio.inmobiliaria.repositories;

import co.edu.uniquindio.inmobiliaria.dto.ProjectDTO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProjectRepository {
    private final JdbcTemplate jdbcTemplate;

    public ProjectRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<ProjectDTO> findAll() {
        String sql = "SELECT id, name, address, number_of_apartments FROM Project";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            ProjectDTO project = new ProjectDTO();
            project.setId(rs.getInt("id"));
            project.setName(rs.getString("name"));
            project.setAddress(rs.getString("address"));
            project.setNumberOfApartments(rs.getInt("number_of_apartments"));
            return project;
        });
    }

    public ProjectDTO findById(Integer id) {
        String sql = "SELECT id, name, address, number_of_apartments FROM Project WHERE id = ?";
        List<ProjectDTO> result = jdbcTemplate.query(sql, new Object[]{id}, (rs, rowNum) -> {
            ProjectDTO project = new ProjectDTO();
            project.setId(rs.getInt("id"));
            project.setName(rs.getString("name"));
            project.setAddress(rs.getString("address"));
            project.setNumberOfApartments(rs.getInt("number_of_apartments"));
            return project;
        });
        return result.isEmpty() ? null : result.get(0);
    }

    public void save(ProjectDTO project) {
        String sql = "INSERT INTO Project (name, address, number_of_apartments) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, project.getName(), project.getAddress(), project.getNumberOfApartments());
    }

    public void update(Integer id, ProjectDTO project) {
        String sql = "UPDATE Project SET name = ?, address = ?, number_of_apartments = ? WHERE id = ?";
        jdbcTemplate.update(sql, project.getName(), project.getAddress(), project.getNumberOfApartments(), id);
    }

    public void delete(Integer id) {
        String sql = "DELETE FROM Project WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
