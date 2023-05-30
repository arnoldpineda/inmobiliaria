package co.edu.uniquindio.inmobiliaria.repositories;

import co.edu.uniquindio.inmobiliaria.dto.EmployeeDTO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepository {
    private final JdbcTemplate jdbcTemplate;
    private final PositionRepository positionRepository;
    private final BranchRepository branchRepository;

    public EmployeeRepository(JdbcTemplate jdbcTemplate, PositionRepository positionRepository, BranchRepository branchRepository) {
        this.jdbcTemplate = jdbcTemplate;
        this.positionRepository = positionRepository;
        this.branchRepository = branchRepository;
    }

    public List<EmployeeDTO> findAll() {
        String sql = "SELECT id, phone, pay, commission_percentage, position_id, branch_id, dni, name, email, password FROM Employee";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            EmployeeDTO employee = new EmployeeDTO();
            employee.setId(rs.getInt("id"));
            employee.setDni(rs.getString("dni"));
            employee.setName(rs.getString("name"));
            employee.setEmail(rs.getString("email"));
            employee.setPassword(rs.getString("password"));
            employee.setPhone(rs.getString("phone"));
            employee.setPay(rs.getDouble("pay"));
            employee.setCommissionPercentage(rs.getDouble("commission_percentage"));
            employee.setPosition(positionRepository.findById(rs.getInt("position_id")));
            employee.setBranch(branchRepository.findById(rs.getInt("branch_id")));
            return employee;
        });
    }

    public EmployeeDTO findById(Integer id) {
        String sql = "SELECT id, phone, pay, commission_percentage, position_id, branch_id, dni, name, email, password FROM Employee WHERE id = ?";
        List<EmployeeDTO> result = jdbcTemplate.query(sql, new Object[]{id}, (rs, rowNum) -> {
            EmployeeDTO employee = new EmployeeDTO();
            employee.setId(rs.getInt("id"));
            employee.setDni(rs.getString("dni"));
            employee.setName(rs.getString("name"));
            employee.setEmail(rs.getString("email"));
            employee.setPassword(rs.getString("password"));
            employee.setPhone(rs.getString("phone"));
            employee.setPay(rs.getDouble("pay"));
            employee.setCommissionPercentage(rs.getDouble("commission_percentage"));
            employee.setPosition(positionRepository.findById(rs.getInt("position_id")));
            employee.setBranch(branchRepository.findById(rs.getInt("branch_id")));
            return employee;
        });
        return result.isEmpty() ? null : result.get(0);
    }

    public void save(EmployeeDTO employee) {
        String sql = "INSERT INTO Employee (dni, name, email, password, phone, pay, commission_percentage, position_id, branch_id) " + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, employee.getDni(), employee.getName(), employee.getEmail(), employee.getPassword(), employee.getPhone(), employee.getPay(), employee.getCommissionPercentage(), employee.getPosition().getId(), employee.getBranch().getId());
    }

    public void update(Integer id, EmployeeDTO employee) {
        String sql = "UPDATE Employee SET dni = ?, name = ?, email = ?, password = ?, phone = ?, pay = ?, commission_percentage = ?, position_id = ?, " + "branch_id = ? WHERE id = ?";
        jdbcTemplate.update(sql, employee.getDni(), employee.getName(), employee.getEmail(), employee.getPassword(), employee.getPhone(), employee.getPay(), employee.getCommissionPercentage(), employee.getPosition().getId(), employee.getBranch().getId(), id);
    }

    public void delete(Integer id) {
        String sql = "DELETE FROM Employee WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
