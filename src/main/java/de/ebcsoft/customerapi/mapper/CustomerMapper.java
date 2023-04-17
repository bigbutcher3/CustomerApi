package de.ebcsoft.customerapi.mapper;

import de.ebcsoft.customerapi.dto.CustomerDto;
import de.ebcsoft.customerapi.entity.CustomerEntity;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {

    CustomerDto toDto(CustomerEntity customerEntity);

}
