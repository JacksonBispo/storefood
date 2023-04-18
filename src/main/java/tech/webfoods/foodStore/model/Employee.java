package tech.webfoods.foodStore.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@DiscriminatorValue(Employee.EMPLOYEE)
@Getter
@Setter
@Entity
@NoArgsConstructor
public class Employee extends Person {

    public final static String EMPLOYEE = "employee";
    private LocalDate admissionDate;


    @Builder(builderMethodName = "employeeBuilder")
    public Employee(Long id, String name, String lastName, String cpf, String phone, String celPhone, List<Address> addressList, List<Order> orders, Status status, LocalDate admissionDate, Cargo cargo) {
        super(id, name, lastName, cpf, phone, celPhone, status, addressList, orders);
        this.admissionDate = admissionDate;
        this.cargo = cargo;
    }

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "cargo_id", referencedColumnName = "id")
    private Cargo cargo;

}
