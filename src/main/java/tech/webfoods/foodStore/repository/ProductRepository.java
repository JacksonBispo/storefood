package tech.webfoods.foodStore.repository;

import lombok.NonNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.webfoods.foodStore.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @NonNull
    Page<Product> findAll(@NonNull Pageable pageable);

}
