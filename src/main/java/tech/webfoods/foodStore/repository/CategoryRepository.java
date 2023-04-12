package tech.webfoods.foodStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.webfoods.foodStore.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
