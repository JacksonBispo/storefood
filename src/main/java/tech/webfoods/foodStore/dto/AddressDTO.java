package tech.webfoods.foodStore.dto;

import lombok.Builder;
import lombok.Data;

@Builder(toBuilder = true)
@Data
public class AddressDTO {

    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;


}
