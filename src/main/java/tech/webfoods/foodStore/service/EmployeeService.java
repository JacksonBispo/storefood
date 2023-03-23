package tech.webfoods.foodStore.service;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tech.webfoods.foodStore.converters.EmployeeConverter;
import tech.webfoods.foodStore.dto.AddressDTO;
import tech.webfoods.foodStore.dto.SaveEmployeeDTO;
import tech.webfoods.foodStore.model.*;
import tech.webfoods.foodStore.repository.*;
import tech.webfoods.foodStore.viaCep.ServiceClient;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@AllArgsConstructor
@Service
public class EmployeeService {

    private final PersonRepository personRepository;

    private final CityRepository  cityRepository;

    private final StateRepository stateRepository;

    private final AddressRepository addressRepository;

    private final CargoRepository cargoRepository;

    private final ServiceClient serviceClient;

    public Employee save(SaveEmployeeDTO employeeDTO){

        AddressDTO addressDTO = serviceClient.buscaEnderecoPorCep(employeeDTO.getPostalCode());
        employeeDTO.setPlaceName(addressDTO.getLogradouro());
        employeeDTO.setComplemento(addressDTO.getComplemento());
        employeeDTO.setBairro(addressDTO.getBairro());
        employeeDTO.setLocalidade(addressDTO.getLocalidade());
        employeeDTO.setUf(addressDTO.getUf());
        employeeDTO.setCity(addressDTO.getLocalidade());

      Address address = addressRepository.findBypostalCode(employeeDTO.getPostalCode());

        State state = stateRepository.findByDsSigla(employeeDTO.getUf());

           State newState =  State.builder()
                    .dsSigla(employeeDTO.getUf())
                    .build();

      City city = cityRepository.findByName(employeeDTO.getLocalidade());

           City newCity = City.builder()
                    .name(employeeDTO.getLocalidade())
                    .state(state != null ? state : newState)
                    .build();

        District district = District.builder()
                .name(employeeDTO.getBairro())
                .cidade(city != null ? city : newCity)
                .build();


        Address newAddress = Address.builder()
                .name(employeeDTO.getPlaceName())
                .number(employeeDTO.getNumber())
                .complemento(employeeDTO.getComplemento())
                .postalCode(employeeDTO.getPostalCode())
                .district(district)
                .build();

       Cargo cargo = cargoRepository.findByName(employeeDTO.getCargo());

        Cargo newCargo = Cargo.builder()
                .name(employeeDTO.getCargo())
                .build();

       Employee employee = Employee.employeeBuilder()
                .id(null)
                .name(employeeDTO.getName())
                .lastName(employeeDTO.getLastName())
                .cpf(employeeDTO.getCpf())
                .phone(employeeDTO.getPhone())
                .celPhone(employeeDTO.getCelPhone())
                .orders(Collections.emptyList())
                .birthDate(employeeDTO.getBirthDate())
               .admissionDate(LocalDate.now())
               .cargo(cargo != null ? cargo : newCargo)
               .addressList(List.of(address != null ? address : newAddress))
               .build();
                newAddress.setPerson(employee);

        EmployeeConverter.toEntity(employeeDTO);

        return personRepository.save(employee);
    }





}
