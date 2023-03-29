package tech.webfoods.foodStore.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder(toBuilder = true)
@Table(name = "TB_PRODUTOS")
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @ManyToMany
    @JoinTable(name="product_ingredient", joinColumns=
            {@JoinColumn(name="product_id")}, inverseJoinColumns=
            {@JoinColumn(name="ingredient_id")})
    private List<Ingredient> ingredients = new ArrayList<>();

    private BigDecimal price;

    @ManyToOne(targetEntity = Product.class,optional = false)
    private Category category;
}
