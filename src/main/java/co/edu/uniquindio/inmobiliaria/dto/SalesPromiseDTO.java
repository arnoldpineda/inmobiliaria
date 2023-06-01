package co.edu.uniquindio.inmobiliaria.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SalesPromiseDTO {
    private Integer id;
    private LocalDateTime saleDate;
    private Double saleValue;
    private Integer realEstateNumber;
    private Boolean credit;
    private LocalDateTime creditDisbursementDate;
    private Double creditValue;
    private List<FeeDTO> fees;
    private BankDTO bank;
    private EmployeeDTO agent;
    private CustomerDTO customer;
    private RealEstateDTO realEstate;
}
