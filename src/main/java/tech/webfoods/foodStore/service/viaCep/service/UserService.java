package tech.webfoods.foodStore.service.viaCep.service;

import org.springframework.security.core.context.SecurityContextHolder;
import tech.webfoods.foodStore.model.User;

public class UserService {

    public static User authenticated(){
        try {
            return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        }catch (Exception e){
            return null;
        }
    }
}
