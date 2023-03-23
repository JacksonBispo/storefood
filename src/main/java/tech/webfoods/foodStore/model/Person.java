package tech.webfoods.foodStore.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Data;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME)
@DiscriminatorColumn(name = "person_type", discriminatorType = DiscriminatorType.STRING)
@Data
@AllArgsConstructor
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastName;
    private String cpf;
    private String phone;
    private String celPhone;

    private LocalDate birthDate;


    @OneToMany(mappedBy = "person",cascade = CascadeType.ALL)
    private List<Address> addressList;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cargo_id", referencedColumnName = "id")
    private Cargo cargo;

    @OneToMany(mappedBy = "person")
    private List<Order> orders;

}
