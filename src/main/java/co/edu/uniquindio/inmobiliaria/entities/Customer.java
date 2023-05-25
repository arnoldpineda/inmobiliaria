package co.edu.uniquindio.inmobiliaria.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import java.util.List;

@Entity
@ToString(callSuper = true)
@Getter
@Setter
@NoArgsConstructor
public class Customer extends User {
    @Length(max = 100)
    @Column(length = 100, nullable = false)
    private String address;

    @Enumerated(EnumType.STRING)
    private CustomerStatus status;

    @ToString.Exclude
    @OneToMany(mappedBy = "customer")
    private List<Phone> phones;

    @ManyToOne
    @JoinColumn(nullable = false)
    private City city;
}
