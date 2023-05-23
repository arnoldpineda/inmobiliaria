package co.edu.uniquindio.inmobiliaria.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.util.List;

@Entity
@ToString(callSuper = true)
@Getter
@Setter
@NoArgsConstructor
public class Customer extends User {
    @Length(max = 100)
    @NotNull
    @Column(length = 100, nullable = false)
    private String address;

    @ToString.Exclude
    @OneToMany(mappedBy = "customer")
    private List<Phone> phones;

    @ManyToOne
    @JoinColumn(nullable = false)
    private City city;
}
