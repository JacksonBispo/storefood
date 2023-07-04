package tech.webfoods.foodStore.usecase;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import tech.webfoods.foodStore.converters.AddressConverter;
import tech.webfoods.foodStore.model.Customer;
import tech.webfoods.foodStore.model.Status;
import tech.webfoods.foodStore.model.User;
import tech.webfoods.foodStore.model.enums.Profile;
import tech.webfoods.foodStore.repository.CustomerRepository;
import tech.webfoods.foodStore.repository.EmployeeRepository;
import tech.webfoods.foodStore.service.viaCep.ServiceClient;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public class SaveCustomersAndEmployeer {


    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ServiceClient viaCep;

    @Autowired
    private PasswordEncoder encoder;



    public void execute(){

        var addressDTO = viaCep.buscaEnderecoPorCep("05077010");

        var customer = Customer.customerBuilder()
                .name("Jackson")
                .lastName("Bispo")
                .cpf("39219796948")
                .phone("9919199219")
                .celPhone("8291892198")
                .orders(null)
                .birthDate(LocalDate.parse("1989-06-04"))
                .status(Status.ACTIVE)
                .user(User.builder()
                        .login("jackson.novaes@live.com")
                        .pass(encoder.encode("11223344"))
                        .roles(Set.of(Profile.ADMIN.getDescription()))
                        .build())
                .addressList(List.of(AddressConverter.toEntity(addressDTO)))
                .build();

        customerRepository.save(customer);

    }
}
