package tech.webfoods.foodStore.resources;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.webfoods.foodStore.dto.LoginDTO;
import tech.webfoods.foodStore.model.User;
import tech.webfoods.foodStore.security.TokenJWT;
import tech.webfoods.foodStore.security.TokenService;

@RestController
@RequestMapping("/login")
@AllArgsConstructor
public class LoginController {

    private final AuthenticationManager manager;

    private final TokenService tokenService;
    @PostMapping
    public ResponseEntity<TokenJWT> login(@RequestBody @Valid LoginDTO loginDTO){
        var token = new UsernamePasswordAuthenticationToken(loginDTO.login(), loginDTO.pass());
        var authentication = manager.authenticate(token);
        var tokenJwt = tokenService.generateWebToken((User) authentication.getPrincipal());
        return ResponseEntity.ok(new TokenJWT(tokenJwt));

    }
}

