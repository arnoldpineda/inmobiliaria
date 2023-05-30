package co.edu.uniquindio.inmobiliaria.dto;

import co.edu.uniquindio.inmobiliaria.entities.VisitType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InteractionDTO {
    private Integer id;
    private LocalDateTime date;
    private String description;
    private VisitType visitType;
    private EmployeeDTO agent;
    private CustomerDTO customer;
}
