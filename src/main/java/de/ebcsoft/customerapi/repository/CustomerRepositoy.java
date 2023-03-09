package de.ebcsoft.customerapi.repository;

import de.ebcsoft.customerapi.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepositoy extends JpaRepository<Customer, Long> {



}
