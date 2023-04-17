package de.ebcsoft.customerapi.entity;

import io.swagger.v3.oas.annotations.media.SchemaProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "Addresses")
@Getter
@Setter
@NoArgsConstructor
public class AddressesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String street;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String houseNumber;

    @Column(nullable = false, columnDefinition = "TEXT", length = 5)
    private String plz;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String city;

    @ManyToMany(mappedBy = "customerToAddress")
    Set<CustomerEntity> addressToCustomer;

    public AddressesEntity(Long id, String street, String houseNumber, String plz, String city) {
        this.id = id;
        this.street = street;
        this.houseNumber = houseNumber;
        this.plz = plz;
        this.city = city;
    }
}
