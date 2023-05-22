package co.edu.uniquindio.inmobiliaria.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;

@Entity
@ToString(callSuper = true)
@Getter
@Setter
@NoArgsConstructor
public class Branch implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;

    @NotNull
    @Length(max = 200)
    @Column(nullable = false, length = 200)
    private String name;

    @NotNull
    @Length(max = 200)
    @Column(nullable = false, length = 200)
    private String address;

    @NotNull
    @Length(max = 12)
    @Column(nullable = false, length = 12)
    private String phone;
}
