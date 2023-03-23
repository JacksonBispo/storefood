package tech.webfoods.foodStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.webfoods.foodStore.model.Cargo;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, Long> {
    Cargo findByName(String name);

}
