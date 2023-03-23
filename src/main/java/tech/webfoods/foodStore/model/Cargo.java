package tech.webfoods.foodStore.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Entity
@AllArgsConstructor
@Data
@Builder
public class Cargo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @JsonBackReference
    @OneToOne(mappedBy = "cargo", cascade = CascadeType.ALL)
    private Person employee;
}
