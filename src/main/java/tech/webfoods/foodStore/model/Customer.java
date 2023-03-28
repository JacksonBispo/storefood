package tech.webfoods.foodStore.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@DiscriminatorValue(Customer.CUSTOMER)
@Getter
@Setter
public class Customer extends Person{

    private LocalDate birthDate;


    public static final String CUSTOMER = "customer";


    public Customer() {
    }


    @Builder(builderMethodName = "customerBuilder")
    public Customer(Long id, String name, String lastName, String cpf, String phone, String celPhone, List<Address> addressList, List<Order> orders, LocalDate birthDate) {
        super(id, name, lastName, cpf, phone, celPhone, addressList, orders);
        this.birthDate = birthDate;
    }
}
