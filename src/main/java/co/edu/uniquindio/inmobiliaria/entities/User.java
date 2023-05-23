package co.edu.uniquindio.inmobiliaria.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;

    @Length(max = 14)
    @Column(nullable = false, length = 14)
    private String dni;

    @Length(max = 200)
    @Column(nullable = false, length = 200)
    private String name;
    
    @Length(max = 100)
    @Email
    @Column(nullable = false, length = 100, unique = true)
    private String email;
}
