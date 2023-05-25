package co.edu.uniquindio.inmobiliaria.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Positive;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class SalesPromise implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Length(max = 200)
    @Column(nullable = false, length = 200)
    private String name;

    @Column(nullable = false)
    private LocalDateTime saleDate;

    @Positive
    @Column(nullable = false)
    private Double saleValue;

    @Positive
    @Column(nullable = false)
    private Integer realEstateNumber;

    @Column(nullable = false)
    private Boolean credit;

    @Column(nullable = false)
    private LocalDateTime creditDisbursementDate;

    @Positive
    @Column(nullable = false)
    private Double creditValue;

    @ToString.Exclude
    @OneToMany(mappedBy = "salesPromise")
    private List<Fee> fees;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Bank bank;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Employee agent;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(nullable = false)
    private RealEstate realEstate;
}
