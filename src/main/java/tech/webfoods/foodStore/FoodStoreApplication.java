package tech.webfoods.foodStore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.crypto.password.PasswordEncoder;
import tech.webfoods.foodStore.converters.AddressConverter;
import tech.webfoods.foodStore.model.Customer;
import tech.webfoods.foodStore.model.Employee;
import tech.webfoods.foodStore.model.Status;
import tech.webfoods.foodStore.model.User;
import tech.webfoods.foodStore.model.enums.Profile;
import tech.webfoods.foodStore.repository.CustomerRepository;
import tech.webfoods.foodStore.repository.EmployeeRepository;
import tech.webfoods.foodStore.service.viaCep.ServiceClient;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@SpringBootApplication
@EnableFeignClients
public class FoodStoreApplication implements CommandLineRunner {


    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ServiceClient viaCep;

    @Autowired
    private PasswordEncoder encoder;


    public static void main(String[] args) {
        SpringApplication.run(FoodStoreApplication.class, args);
    }

    @Override
    public void run(String... args) {
    }
}
