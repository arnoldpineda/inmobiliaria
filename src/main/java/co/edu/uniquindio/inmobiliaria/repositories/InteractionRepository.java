package co.edu.uniquindio.inmobiliaria.repositories;

import co.edu.uniquindio.inmobiliaria.dto.InteractionDTO;
import co.edu.uniquindio.inmobiliaria.entities.VisitType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InteractionRepository {
    private final JdbcTemplate jdbcTemplate;
    private final EmployeeRepository employeeRepository;
    private final CustomerRepository customerRepository;

    @Autowired
    public InteractionRepository(JdbcTemplate jdbcTemplate, EmployeeRepository employeeRepository, CustomerRepository customerRepository) {
        this.jdbcTemplate = jdbcTemplate;
        this.employeeRepository = employeeRepository;
        this.customerRepository = customerRepository;
    }

    public List<InteractionDTO> findAll() {
        String sql = "SELECT id, date, description, visit_type, agent_id, customer_id FROM Interaction";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            InteractionDTO interaction = new InteractionDTO();
            interaction.setId(rs.getInt("id"));
            interaction.setDate(rs.getTimestamp("date").toLocalDateTime());
            interaction.setDescription(rs.getString("description"));
            interaction.setVisitType(VisitType.valueOf(rs.getString("visit_type")));
            interaction.setAgent(employeeRepository.findById(rs.getInt("agent_id")));
            interaction.setCustomer(customerRepository.findById(rs.getInt("customer_id")));
            return interaction;
        });
    }

    public InteractionDTO findById(Integer id) {
        String sql = "SELECT id, date, description, visit_type, agent_id, customer_id FROM Interaction WHERE id = ?";
        List<InteractionDTO> result = jdbcTemplate.query(sql, new Object[]{id}, (rs, rowNum) -> {
            InteractionDTO interaction = new InteractionDTO();
            interaction.setId(rs.getInt("id"));
            interaction.setDate(rs.getTimestamp("date").toLocalDateTime());
            interaction.setDescription(rs.getString("description"));
            interaction.setVisitType(VisitType.valueOf(rs.getString("visit_type")));
            interaction.setAgent(employeeRepository.findById(rs.getInt("agent_id")));
            interaction.setCustomer(customerRepository.findById(rs.getInt("customer_id")));
            return interaction;
        });
        return result.isEmpty() ? null : result.get(0);
    }

    public void save(InteractionDTO interaction) {
        String sql = "INSERT INTO Interaction (date, description, visit_type, agent_id, customer_id) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, interaction.getDate(), interaction.getDescription(), interaction.getVisitType().name(), interaction.getAgent().getId(), interaction.getCustomer().getId());
    }

    public void update(Integer id, InteractionDTO interaction) {
        String sql = "UPDATE Interaction SET date = ?, description = ?, visit_type = ?, agent_id = ?, customer_id = ? WHERE id = ?";
        jdbcTemplate.update(sql, interaction.getDate(), interaction.getDescription(), interaction.getVisitType().name(), interaction.getAgent().getId(), interaction.getCustomer().getId(), id);
    }

    public void delete(Integer id) {
        String sql = "DELETE FROM Interaction WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
