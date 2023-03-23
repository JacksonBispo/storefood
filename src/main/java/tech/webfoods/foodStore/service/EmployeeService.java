package tech.webfoods.foodStore.service;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tech.webfoods.foodStore.converters.CustomerConverter;
import tech.webfoods.foodStore.converters.EmployeeConverter;
import tech.webfoods.foodStore.dto.AddressDTO;
import tech.webfoods.foodStore.dto.SaveCustomerDTO;
import tech.webfoods.foodStore.dto.SaveEmployeeDTO;
import tech.webfoods.foodStore.model.Customer;
import tech.webfoods.foodStore.model.Employee;
import tech.webfoods.foodStore.repository.PersonRepository;
import tech.webfoods.foodStore.viaCep.ServiceClient;

@AllArgsConstructor
@Service
public class EmployeeService {

    private final PersonRepository personRepository;

    private final ServiceClient serviceClient;

    public Employee save(SaveEmployeeDTO employeeDTO){
       AddressDTO addressDTO = serviceClient.buscaEnderecoPorCep(employeeDTO.getPostalCode());
        employeeDTO.setPlaceName(addressDTO.getLogradouro());
        employeeDTO.setComplemento(addressDTO.getComplemento());
        employeeDTO.setBairro(addressDTO.getBairro());
        employeeDTO.setLocalidade(addressDTO.getLocalidade());
        employeeDTO.setUf(addressDTO.getUf());
        employeeDTO.setCity(addressDTO.getLocalidade());
        return personRepository.save(EmployeeConverter.toEntity(employeeDTO));
    }
}
