package tech.webfoods.foodStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.webfoods.foodStore.model.Customer;

@Repository
public interface PersonRepository extends JpaRepository<Customer, Long> {


}
