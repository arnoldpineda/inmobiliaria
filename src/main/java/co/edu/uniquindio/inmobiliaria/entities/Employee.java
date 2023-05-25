package co.edu.uniquindio.inmobiliaria.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

@Entity
@ToString(callSuper = true)
@Getter
@Setter
@NoArgsConstructor
public class Employee extends User {
    @Length(max = 14)
    @Column(length = 14, nullable = false)
    private String phone;

    @Positive
    @Column(nullable = false)
    private Double pay;

    @Positive
    @DecimalMin(value = "0.0")
    @DecimalMax(value = "100.0")
    private Double commissionPercentage;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Position position;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Branch branch;
}
