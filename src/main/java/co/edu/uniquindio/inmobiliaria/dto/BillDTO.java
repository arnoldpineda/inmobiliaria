package co.edu.uniquindio.inmobiliaria.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BillDTO {
    private Integer id;
    private Double value;
    private LocalDateTime date;
    private CustomerDTO customer;
    private RealEstateDTO realEstate;
}
