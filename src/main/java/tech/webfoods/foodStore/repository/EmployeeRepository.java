package tech.webfoods.foodStore.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.webfoods.foodStore.model.Employee;
import tech.webfoods.foodStore.model.Status;

import java.util.UUID;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, UUID> {

    Page<Employee> findByStatus(Pageable pageable, Status status);

}
