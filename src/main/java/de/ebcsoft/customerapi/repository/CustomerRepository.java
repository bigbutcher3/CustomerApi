package de.ebcsoft.customerapi.repository;

import de.ebcsoft.customerapi.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {}