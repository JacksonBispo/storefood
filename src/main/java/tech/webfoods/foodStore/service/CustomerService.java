package tech.webfoods.foodStore.service;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tech.webfoods.foodStore.converters.CustomerConverter;
import tech.webfoods.foodStore.dto.AddressDTO;
import tech.webfoods.foodStore.dto.SaveCustomerDTO;
import tech.webfoods.foodStore.model.Customer;
import tech.webfoods.foodStore.model.Employee;
import tech.webfoods.foodStore.repository.PersonRepository;
import tech.webfoods.foodStore.viaCep.ServiceClient;

@AllArgsConstructor
@Service
public class CustomerService {

    private final PersonRepository personRepository;

    private final ServiceClient serviceClient;

    public Customer save(SaveCustomerDTO customerDTO){
       AddressDTO addressDTO = serviceClient.buscaEnderecoPorCep(customerDTO.getPostalCode());
       customerDTO.setPlaceName(addressDTO.getLogradouro());
       customerDTO.setComplemento(addressDTO.getComplemento());
       customerDTO.setBairro(addressDTO.getBairro());
       customerDTO.setLocalidade(addressDTO.getLocalidade());
       customerDTO.setUf(addressDTO.getUf());
       customerDTO.setCity(addressDTO.getLocalidade());
        return personRepository.save(CustomerConverter.toEntity(customerDTO));
    }
}
