package de.ebcsoft.customerapi.controller;

import de.ebcsoft.customerapi.dto.AddressesDto;
import de.ebcsoft.customerapi.entity.AddressesEntity;
import de.ebcsoft.customerapi.repository.AddressesRepository;
import de.ebcsoft.customerapi.services.AddressesService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addresses")
public class AddressesController {

    private final AddressesService addressesService;

    AddressesRepository addressesRepository;

    public AddressesController(AddressesService addressesService, AddressesRepository addressesRepository) {
        this.addressesService = addressesService;
        this.addressesRepository = addressesRepository;
    }

    @GetMapping("")
    @Operation(description = "shows all addresses from DB in JSON format", method = "index", summary = "gets all addresses")
    public List<AddressesDto> index() {
        return addressesService.getAll();
    }

    @GetMapping("one/{id}")
    @Operation(description = "shows that one address with the specific id", method = "getCustomer", summary = "gets one address")
    public AddressesDto getAddress(@PathVariable @Parameter(example = "1") final Long id) {
        return addressesService.getAddress(id);
    }

    @PostMapping
    @Operation(description = "creates a new address in DB from JSON", summary = "creates new address", method = "createAddress")
    public String createAddress(@RequestBody AddressesEntity addressesEntity) {
        return addressesService.createAddress(addressesEntity);
    }

    @PutMapping
    @Operation(description = "updates a specific address", method = "updateAddress", summary = "updates a address")
    public String updateAddress(@RequestBody AddressesEntity addressesEntity) {
        return addressesService.updateAddress(addressesEntity);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(description = "deletes a specific address", summary = "deletes a address", method = "deleteAddress")
    public String deleteAddress(@PathVariable Long id) {
        return addressesService.deleteAddress(id);
    }
}