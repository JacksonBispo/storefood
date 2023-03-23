package tech.webfoods.foodStore.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@Getter
@Setter

@Table(name = "tb_cities")
@Builder(toBuilder = true)
public class City {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "state_id")
	private State state;

	@OneToMany(mappedBy = "city", cascade = CascadeType.ALL)
	private List<Address> addresses;

}