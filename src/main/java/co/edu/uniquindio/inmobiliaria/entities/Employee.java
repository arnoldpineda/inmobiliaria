package co.edu.uniquindio.inmobiliaria.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
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

  @Column(nullable = false)
  private float pay;

  @DecimalMin(value = "0.0")
  @DecimalMax(value = "100.0")
  private float commissionPercentage;

  @ManyToOne
  @JoinColumn(nullable = false)
  private Position position;

  @ManyToOne
  @JoinColumn(nullable = false)
  private Branch branch;
}
