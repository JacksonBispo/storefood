package tech.webfoods.foodStore.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
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
            Cargo cargo,
            List<Order> orders) {
        super(id, name, lastName, cpf, phone, celPhone, birthDate, addressList, cargo, orders);
    }
}
