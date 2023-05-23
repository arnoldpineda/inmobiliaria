package co.edu.uniquindio.inmobiliaria.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Phone implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;

    @Length(max = 10)
    @Column(nullable = false, length = 10)
    private String number;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Customer customer;
}
