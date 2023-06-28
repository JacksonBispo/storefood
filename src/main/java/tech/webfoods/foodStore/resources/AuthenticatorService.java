package tech.webfoods.foodStore.resources;

import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import tech.webfoods.foodStore.model.User;
import tech.webfoods.foodStore.repository.UserRepository;

@Service
@AllArgsConstructor
public class AuthenticatorService  implements UserDetailsService {

    private final UserRepository repository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByLogin(username);
    }

    public static User authenticated(){
        try {
            return (User) SecurityContextHolder.getContext()
                    .getAuthentication().getPrincipal();
        }catch (Exception e){
            return null;
        }
    }

}
