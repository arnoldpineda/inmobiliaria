package co.edu.uniquindio.inmobiliaria.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@ToString(callSuper = true)
@Getter
@Setter
@NoArgsConstructor
public class Agent extends Employee {
  @Column(nullable = false)
  private float commissionPercentage;
}
