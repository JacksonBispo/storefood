package tech.webfoods.foodStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.webfoods.foodStore.model.State;

@Repository
public interface StateRepository extends JpaRepository<State, Long> {

    State findByDsSigla(String sigla);
}
