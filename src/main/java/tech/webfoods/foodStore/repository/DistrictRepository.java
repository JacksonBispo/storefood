package tech.webfoods.foodStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.webfoods.foodStore.model.District;

@Repository
public interface DistrictRepository extends JpaRepository<District, Long> {
}
