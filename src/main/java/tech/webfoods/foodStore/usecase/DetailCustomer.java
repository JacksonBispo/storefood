package tech.webfoods.foodStore.usecase;


import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tech.webfoods.foodStore.converters.CustomerConverter;
import tech.webfoods.foodStore.dto.CustomerDTO;
import tech.webfoods.foodStore.exceptions.AuthorizationException;
import tech.webfoods.foodStore.model.enums.Profile;
import tech.webfoods.foodStore.repository.CustomerRepository;
import tech.webfoods.foodStore.service.viaCep.service.UserService;

@Service
@AllArgsConstructor
public class DetailCustomer {

    private final CustomerRepository customerRepository;


        public CustomerDTO execute(Long id){
            var userSS = UserService.authenticated();
            if(userSS == null || userSS.hasRole(Profile.ADMIN)
                              || userSS.hasRole(Profile.EMPLOYEE)
                              || userSS.hasRole(Profile.MANAGER)
                     && !id.equals(userSS.getId())){
                throw new AuthorizationException("Access Denied!");
            }

            var employee = customerRepository.findById(id).orElseThrow(EntityNotFoundException::new);
            return CustomerConverter.toDTO(employee);
        }
}
