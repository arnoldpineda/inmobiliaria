package co.edu.uniquindio.inmobiliaria.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BankDTO {
    private Integer id;
    private String name;
    private String phone;
    private String email;
}
