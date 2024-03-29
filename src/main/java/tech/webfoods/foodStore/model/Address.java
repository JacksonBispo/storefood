package tech.webfoods.foodStore.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder(toBuilder = true)
@Table(name = "TB_ADDRESS")
public class Address implements Serializable {

    @Serial
    private static final long serialVersionUID = 2662999979467455549L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String uuid;
    private String number;
    private String name;
    private String postalCode;

    private String complemento;

    private String bairro;
    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "person_id")
    private Person person;

    private String city;

    private String uf;

    @PrePersist
    public void prePersist() {
        this.uuid = UUID.randomUUID().toString();
    }
}
