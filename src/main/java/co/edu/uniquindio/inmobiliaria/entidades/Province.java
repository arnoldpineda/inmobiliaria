package co.edu.uniquindio.inmobiliaria.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.util.List;

@Entity
@Inheritance (strategy = InheritanceType.TABLE_PER_CLASS)
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Province implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;

    @NotNull
    @Length(max = 50)
    @Column(nullable = false, length = 50)
    private String name;

    @ManyToOne
    @JoinColumn (nullable = false)
    private Country country;

    @OneToMany(mappedBy = "province")
    private List<City> cities;
}
