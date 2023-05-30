package co.edu.uniquindio.inmobiliaria.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {
    private Integer id;
    private String dni;
    private String name;
    private String email;
    private String password;
    private String phone;
    private Double pay;
    private Double commissionPercentage;
    private PositionDTO position;
    private BranchDTO branch;
}
