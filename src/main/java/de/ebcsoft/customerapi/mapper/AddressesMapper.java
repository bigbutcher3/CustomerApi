package de.ebcsoft.customerapi.mapper;

import de.ebcsoft.customerapi.dto.AddressesDto;
import de.ebcsoft.customerapi.entity.AddressesEntity;
import org.mapstruct.Mapper;

@Mapper
public interface AddressesMapper {

    AddressesDto toDto(AddressesEntity addresses);

}
