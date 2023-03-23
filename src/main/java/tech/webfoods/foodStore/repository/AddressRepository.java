package tech.webfoods.foodStore.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.webfoods.foodStore.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    Address findBypostalCode(String postalcode);
}