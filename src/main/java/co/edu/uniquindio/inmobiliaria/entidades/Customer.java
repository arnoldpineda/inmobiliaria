package co.edu.uniquindio.inmobiliaria.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.util.List;

@Entity
@ToString(callSuper = true)
@Getter
@Setter
@NoArgsConstructor
public class Customer extends User implements Serializable {
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
