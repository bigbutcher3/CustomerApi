package de.ebcsoft.customerapi.services;

import de.ebcsoft.customerapi.dto.CustomerDto;
import de.ebcsoft.customerapi.entity.CustomerEntity;
import de.ebcsoft.customerapi.mapper.CustomerMapper;
import de.ebcsoft.customerapi.repository.CustomerRepository;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    private final CustomerRepository repository;
    private final CustomerMapper mapper;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
        this.mapper = Mappers.getMapper(CustomerMapper.class);
    }

    public List<CustomerDto> getAll() {
        List<CustomerEntity> entities = repository.findAll();
        return entities.stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    public CustomerDto getCustomer(Long id){
        var entity = repository.findById(id);
        if(entity.isEmpty()) {
            return new CustomerDto();
        }
        return mapper.toDto(entity.get());
    }

    public String createCustomer(CustomerEntity customerEntity) {
        repository.save(customerEntity);
        return "Customer Added Successfully";
    }

    public String updateCustomer(CustomerEntity customerEntity) {
        if(repository.findById(customerEntity.getId()).isEmpty()) {
            return "No Customer found with this ID";
        }
        repository.save(customerEntity);
        return "Customer Updated Successfully";
    }

    public String deleteCustomer(Long id) {
        if(repository.findById(id).isEmpty()) {
            return "No Customer found with this ID";
        }
        repository.deleteById(id);
        return "Customer Deleted Successfully";
    }
}
