package co.edu.uniquindio.inmobiliaria.dto;

import co.edu.uniquindio.inmobiliaria.entities.RealEstateStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RealEstateDTO {
    private Integer id;
    private String nomenclature;
    private Double privateArea;
    private Double builtArea;
    private Double valuePerSquareMeter;
    private RealEstateStatus status;
    private ProjectDTO project;
}
