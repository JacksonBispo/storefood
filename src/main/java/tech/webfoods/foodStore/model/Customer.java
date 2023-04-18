package tech.webfoods.foodStore.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@DiscriminatorValue(Customer.CUSTOMER)
@Getter
@Setter
@NoArgsConstructor
public class Customer extends Person {

    private LocalDate birthDate;


    public static final String CUSTOMER = "customer";

    @Builder(builderMethodName = "customerBuilder")
    public Customer(Long id, String name, String lastName, String cpf, String phone, String celPhone, List<Address> addressList, List<Order> orders, LocalDate birthDate,Status status) {
        super(id, name, lastName, cpf, phone, celPhone, status, addressList, orders);
        this.birthDate = birthDate;
    }
}
