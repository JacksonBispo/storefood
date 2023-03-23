package tech.webfoods.foodStore.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@Builder(toBuilder = true)
@Table(name = "TB_ESTADOS")
public class State {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String dsSigla;
	@OneToMany(mappedBy = "state", cascade = CascadeType.ALL)
	private List<City> cities;
}
