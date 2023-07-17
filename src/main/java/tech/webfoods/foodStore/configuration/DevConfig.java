package tech.webfoods.foodStore.configuration;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import tech.webfoods.foodStore.service.viaCep.service.DbService;

@Configuration
@Profile("dev")
public class DevConfig {

    @Autowired
    private DbService dbService;

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String strategy;

    @Bean
    public boolean instantiateDatabase(){
        if ("create".equals(strategy) || "create-drop".equals(strategy)){
            dbService.instantiateTestDB();
            return true;
        }
        return false;
    }
}
