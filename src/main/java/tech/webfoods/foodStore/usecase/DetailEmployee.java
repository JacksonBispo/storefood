package tech.webfoods.foodStore.usecase;


import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tech.webfoods.foodStore.converters.EmployeeConverter;
import tech.webfoods.foodStore.dto.EmployeeDTO;
import tech.webfoods.foodStore.exceptions.AuthorizationException;
import tech.webfoods.foodStore.model.enums.Profile;
import tech.webfoods.foodStore.repository.EmployeeRepository;
import tech.webfoods.foodStore.service.viaCep.service.UserService;

@Service
@AllArgsConstructor
public class DetailEmployee {

    private final EmployeeRepository employeeRepository;

    public EmployeeDTO execute(Long id){

        var userSS = UserService.authenticated();
        if(userSS != null || userSS.hasRole(Profile.ADMIN)
                || userSS.hasRole(Profile.MANAGER) && !id.equals(userSS.getId())){
            throw new AuthorizationException("Access Denied!");
        }
        var employee = employeeRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return EmployeeConverter.toDTO(employee);
    }
}
