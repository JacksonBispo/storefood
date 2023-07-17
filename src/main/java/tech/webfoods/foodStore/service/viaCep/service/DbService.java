package tech.webfoods.foodStore.service.viaCep.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tech.webfoods.foodStore.converters.AddressConverter;
import tech.webfoods.foodStore.model.*;
import tech.webfoods.foodStore.model.enums.Profile;
import tech.webfoods.foodStore.repository.AddressRepository;
import tech.webfoods.foodStore.repository.CustomerRepository;
import tech.webfoods.foodStore.repository.EmployeeRepository;
import tech.webfoods.foodStore.repository.UserRepository;
import tech.webfoods.foodStore.service.viaCep.ServiceClient;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
@Service
public class DbService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private ServiceClient viaCep;

    @Autowired
    private PasswordEncoder encoder;

    public void instantiateTestDB() {

        var addressDTO = viaCep.buscaEnderecoPorCep("05077010");
        var addressDTO2 = viaCep.buscaEnderecoPorCep("08143090");
        var addressDTO3 = viaCep.buscaEnderecoPorCep("08140090");
        var address = AddressConverter.toEntity(addressDTO);
        var address2 = AddressConverter.toEntity(addressDTO2);
        var address3 = AddressConverter.toEntity(addressDTO3);
        var user = User.builder()
                .login("jackson.novaes@live.com")
                .pass(encoder.encode("11223344"))
                .roles(Set.of(Profile.CLIENT.getDescription()))
                .build();

        var customer = Customer.customerBuilder()
                .name("Jackson")
                .lastName("Bispo")
                .cpf("39219796948")
                .phone("9919199219")
                .celPhone("8291892198")
                .orders(null)
                .birthDate(LocalDate.parse("1989-06-04"))
                .status(Status.ACTIVE)
                .user(user)
                .addressList(List.of(address))
                .build();
                address.setPerson(customer);
        var user2 = User.builder()
                .login("jackson.novaes@gmail.com")
                .pass(encoder.encode("11223344"))
                .roles(Set.of(Profile.CLIENT.getDescription()))
                .build();
        var customer3 = Customer.customerBuilder()
                .name("Jackson")
                .lastName("nos")
                .cpf("39219796948")
                .phone("9919199219")
                .celPhone("8291892198")
                .orders(null)
                .birthDate(LocalDate.parse("1989-06-04"))
                .status(Status.ACTIVE)
                .user(user2)
                .addressList(List.of(address))
                .build();
                address2.setPerson(customer3);

       var user3 = User.builder()
                .login("jackson.novaes@iftech.com")
                .pass(encoder.encode("11223344"))
                .roles(Set.of(Profile.ADMIN.getDescription()))
                .build();

        var employee = Employee.employeeBuilder()
                .name("Jackson")
                .lastName("Novaes")
                .cpf("39219796948")
                .phone("9919199219")
                .celPhone("8291892198")
                .orders(null)
                .admissionDate(LocalDate.now())
                .status(Status.ACTIVE)
                .user(user3)
                .cargo(Cargo.builder()
                        .name("Gerente")
                        .build())
                .addressList(List.of(address3))
                .build();
        address.setPerson(employee);
        userRepository.saveAll(Arrays.asList(user,user2,user3));
        employeeRepository.saveAll(Collections.singletonList(employee));
        customerRepository.saveAll(Arrays.asList(customer,customer3));
        addressRepository.saveAll(List.of(address,address2,address3));
    }
}

