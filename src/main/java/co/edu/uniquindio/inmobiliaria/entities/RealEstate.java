package co.edu.uniquindio.inmobiliaria.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Positive;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class RealEstate implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Length(max = 200)
    @Column(nullable = false, length = 200)
    private String nomenclature;

    @Positive
    @Column(nullable = false)
    private Double privateArea;

    @Positive
    @Column(nullable = false)
    private Double builtArea;

    @Positive
    @Column(nullable = false)
    private Double valuePerSquareMeter;

    @Enumerated(EnumType.STRING)
    private RealEstateStatus status;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Project project;
}
