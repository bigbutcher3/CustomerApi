package de.ebcsoft.customerapi.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.Set;

@Entity
@Table(name = "Customer")
@Getter
@Setter
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private long id;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String firstName;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String lastName;

    @Column(columnDefinition = "TEXT")
    private String city;

    @Column(nullable = false, columnDefinition = "DATE")
    private Date birthdayDay;

    @Column(columnDefinition = "TEXT")
    private String secret;

    @ManyToMany
        @JoinTable(
                name = "customer_address",
                joinColumns = @JoinColumn(name = "customer_id"),
                inverseJoinColumns = @JoinColumn(name = "address_id")
        )
    Set<AddressesEntity> customerToAddress;
}
