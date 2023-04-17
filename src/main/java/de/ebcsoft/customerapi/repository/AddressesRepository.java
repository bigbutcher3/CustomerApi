package de.ebcsoft.customerapi.repository;

import de.ebcsoft.customerapi.entity.AddressesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressesRepository extends JpaRepository<AddressesEntity, Long> {}