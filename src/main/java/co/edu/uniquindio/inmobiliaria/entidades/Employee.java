package co.edu.uniquindio.inmobiliaria.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;

@Entity
@ToString(callSuper = true)
@Getter
@Setter
@NoArgsConstructor
public class Employee extends User {
  @Length(max = 14)
  @NotNull
  @Column(length = 14, nullable = false)
  private String phone;

  @NotNull
  @Column(nullable = false)
  private float salario;

  @ManyToOne
  @JoinColumn(nullable = false)
  private Position position;

  @ManyToOne
  @JoinColumn(nullable = false)
  private Branch branch;
}
