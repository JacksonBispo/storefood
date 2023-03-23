package tech.webfoods.foodStore.service;

import org.springframework.stereotype.Service;
import tech.webfoods.foodStore.dto.SavePersonDTO;
import tech.webfoods.foodStore.model.Person;

@Service
public interface PersonService {

     Person save(SavePersonDTO personDTO);
}
