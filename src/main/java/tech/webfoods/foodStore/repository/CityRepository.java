package tech.webfoods.foodStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.webfoods.foodStore.model.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    City findByName(String name);

}
