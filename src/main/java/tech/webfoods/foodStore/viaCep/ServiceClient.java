package tech.webfoods.foodStore.viaCep;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import tech.webfoods.foodStore.dto.AddressDTO;

@Component
@FeignClient(url = "https://viacep.com.br/ws/" , name = "viacep")
public interface ServiceClient {

  @GetMapping("{cep}/json")
  AddressDTO buscaEnderecoPorCep(@PathVariable("cep") String cep);

}
