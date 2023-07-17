package tech.webfoods.foodStore.usecase;


import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tech.webfoods.foodStore.dto.AddressDTO;
import tech.webfoods.foodStore.dto.SaveEmployeeDTO;
import tech.webfoods.foodStore.exceptions.FieldNotValidException;
import tech.webfoods.foodStore.model.*;
import tech.webfoods.foodStore.model.enums.Profile;
import tech.webfoods.foodStore.repository.AddressRepository;
import tech.webfoods.foodStore.repository.CargoRepository;
import tech.webfoods.foodStore.repository.EmployeeRepository;
import tech.webfoods.foodStore.repository.UserRepository;
import tech.webfoods.foodStore.service.viaCep.ServiceClient;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Service
public class SaveEmployee {

    private final EmployeeRepository personRepository;

    private final CargoRepository cargoRepository;

    private final ServiceClient serviceClient;

    private final UserRepository userRepository;

    private final AddressRepository addressRepository;

    private final PasswordEncoder encoder;

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
                .admissionDate(LocalDate.now())
                .addressList(List.of(address))
                .profiles(Set.of(Profile.EMPLOYEE.getCod()))
                .build();

        address.setPerson(employee);

        Cargo newCargo = Cargo.builder()
                .name(employeeDTO.getCargo())
                .build();
        User user = User.builder()
                .login(employeeDTO.getLogin())
                .pass(encoder.encode(employeeDTO.getPass()))
                .build();
        employee.setUser(user);
        employee.setCargo(newCargo);
        userRepository.save(user);
        cargoRepository.save(employee.getCargo());
        var person =  personRepository.save(employee);
        addressRepository.saveAll(Arrays.asList(address));
        return person;
    }

    private void validateFields(SaveEmployeeDTO employeeDTO) {

        if(employeeDTO.getName().isEmpty()){
            throw new FieldNotValidException("Campo invalido");
        }
    }


}
