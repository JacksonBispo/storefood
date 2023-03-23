package tech.webfoods.foodStore.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@DiscriminatorValue(Employee.EMPLOYEE)
@Getter
@Setter
@Entity
public class Employee extends Person{

    public final static String EMPLOYEE = "employee";
    private LocalDate admissionDate;


    @Builder(builderMethodName = "employeeBuilder")
    public Employee(
            Long id,
            String name,
            String lastName,
            String cpf,
            String phone,
            String celPhone,
            LocalDate birthDate,
            List<Address> addressList,
            Cargo cargo,
            List<Order> orders,
            LocalDate admissionDate) {
        super(id, name, lastName, cpf, phone, celPhone, birthDate, addressList, cargo, orders);
        this.admissionDate = admissionDate;
    }
}
