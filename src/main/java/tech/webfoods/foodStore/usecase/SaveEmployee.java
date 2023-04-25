package tech.webfoods.foodStore.usecase;


import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tech.webfoods.foodStore.dto.AddressDTO;
import tech.webfoods.foodStore.dto.SaveEmployeeDTO;
import tech.webfoods.foodStore.exceptions.FieldNotValidException;
import tech.webfoods.foodStore.model.Address;
import tech.webfoods.foodStore.model.Cargo;
import tech.webfoods.foodStore.model.Employee;
import tech.webfoods.foodStore.model.Status;
import tech.webfoods.foodStore.repository.AddressRepository;
import tech.webfoods.foodStore.repository.CargoRepository;
import tech.webfoods.foodStore.repository.EmployeeRepository;
import tech.webfoods.foodStore.viaCep.ServiceClient;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@AllArgsConstructor
@Service
public class SaveEmployee {

    private final EmployeeRepository personRepository;

    private final CargoRepository cargoRepository;

    private final ServiceClient serviceClient;

    public Employee execute(@Valid SaveEmployeeDTO employeeDTO) {

        AddressDTO addressDTO = serviceClient.buscaEnderecoPorCep(employeeDTO.getPostalCode());
        employeeDTO.setPlaceName(addressDTO.getLogradouro());
        employeeDTO.setComplemento(addressDTO.getComplemento());
        employeeDTO.setBairro(addressDTO.getBairro());
        employeeDTO.setUf(addressDTO.getUf());
        employeeDTO.setCity(addressDTO.getLocalidade());
        Employee employee;

        Address address = Address.builder()
                .name(employeeDTO.getPlaceName())
                .number(employeeDTO.getNumber())
                .complemento(employeeDTO.getComplemento())
                .postalCode(employeeDTO.getPostalCode())
                .bairro(employeeDTO.getBairro())
                .city(employeeDTO.getCity())
                .uf(employeeDTO.getUf())
                .build();

        employee = Employee.employeeBuilder()
                .id(null)
                .name(employeeDTO.getName())
                .lastName(employeeDTO.getLastName())
                .cpf(employeeDTO.getCpf())
                .phone(employeeDTO.getPhone())
                .celPhone(employeeDTO.getCelPhone())
                .status(Status.ACTIVE)
                .orders(Collections.emptyList())
                .admissionDate(employeeDTO.getAdmissionDate())
                .admissionDate(LocalDate.now())
                .addressList(List.of(address))
                .build();

        address.setPerson(employee);

        Cargo newCargo = Cargo.builder()
                .name(employeeDTO.getCargo())
                .build();
        employee.setCargo(newCargo);
        cargoRepository.save(employee.getCargo());
        return personRepository.save(employee);
    }

    private void validateFields(SaveEmployeeDTO employeeDTO) {

        if(employeeDTO.getName().isEmpty()){
            throw new FieldNotValidException("Campo invalido");
        }
    }


}
