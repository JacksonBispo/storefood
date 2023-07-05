package tech.webfoods.foodStore.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@DiscriminatorValue(Employee.EMPLOYEE)
@Getter
@Setter
@Entity
@NoArgsConstructor
public class Employee extends Person {

    public final static String EMPLOYEE = "employee";
    private LocalDate admissionDate;


    @Builder(builderMethodName = "employeeBuilder")
    public Employee(
            UUID id,
            String name,
            String lastName,
            String cpf,
            String phone,
            String celPhone,
            List<Address> addressList,
            List<Order> orders,
            Status status,
            LocalDate admissionDate,
            Cargo cargo,
            User user,
            Set<Integer> profiles
            ) {
        super(id, name, lastName, cpf, phone, celPhone, status, user, addressList, orders,profiles);
        this.admissionDate = admissionDate;
        this.cargo = cargo;
    }

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "cargo_id", referencedColumnName = "id")
    private Cargo cargo;

}
