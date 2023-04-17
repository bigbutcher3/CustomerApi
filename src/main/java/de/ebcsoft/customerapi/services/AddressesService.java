package de.ebcsoft.customerapi.services;

import de.ebcsoft.customerapi.dto.AddressesDto;
import de.ebcsoft.customerapi.entity.AddressesEntity;
import de.ebcsoft.customerapi.mapper.AddressesMapper;
import de.ebcsoft.customerapi.repository.AddressesRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressesService {

    private final AddressesRepository repository;
    private final AddressesMapper mapper;

    public AddressesService(AddressesRepository repository) {
        this.repository = repository;
        this.mapper = Mappers.getMapper(AddressesMapper.class);
    }

    public List<AddressesDto> getAll() {
        List<AddressesEntity> entities = repository.findAll();
        return entities.stream().map(mapper::toDto)
                .collect(Collectors.toList());
    }

    public AddressesDto getAddress(Long id) {
        var entity = repository.findById(id);
        if (entity.isEmpty()) {
            return new AddressesDto();
        }
        return mapper.toDto(entity.get());
    }

    public String createAddress(AddressesEntity addressesEntity) {
        repository.save(addressesEntity);
        return "Address Added Successfully";
    }

    public String updateAddress(AddressesEntity addressesEntity) {
        if(repository.findById(addressesEntity.getId()).isEmpty()) {
            return "No Address found with this ID";
        }
        repository.save(addressesEntity);
        return "Address Updated Successfully";
    }

    public String deleteAddress(Long id) {
        if(repository.findById(id).isEmpty()) {
            return "No Address found with this ID";
        }
        repository.deleteById(id);
        return "Address Deleted Successfully";
    }
}
