package tech.webfoods.foodStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.webfoods.foodStore.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
