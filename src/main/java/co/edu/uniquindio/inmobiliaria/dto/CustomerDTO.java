package co.edu.uniquindio.inmobiliaria.dto;

import co.edu.uniquindio.inmobiliaria.entities.CustomerStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {
    private Integer id;
    private String dni;
    private String name;
    private String email;
    private String password;
    private String address;
    private CustomerStatus status;
    private List<PhoneDTO> phones;
    private CityDTO city;
}
