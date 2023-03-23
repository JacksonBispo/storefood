package tech.webfoods.foodStore.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@DiscriminatorValue(Customer.CUSTOMER)
@Getter
@Setter
public class Customer extends Person{


    public static final String CUSTOMER = "customer";


    @Builder(builderMethodName = "customerBuilder")
    public Customer(
            Long id,
            String name,
            String lastName,
            String cpf,
            String phone,
            String celPhone,
            LocalDate birthDate,
            List<Address> addressList,
            List<Order> orders) {
        super(id, name, lastName, cpf, phone, celPhone, birthDate, addressList, orders);
    }
}
