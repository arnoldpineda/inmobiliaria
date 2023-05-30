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
public class FeeDTO {
    private Integer id;
    private LocalDateTime date;
    private Double value;
    private SalesPromiseDTO salesPromise;
    private PaymentDTO payment;
}
