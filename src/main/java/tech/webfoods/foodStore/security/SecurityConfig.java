package tech.webfoods.foodStore.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

    private static final String[] PUBLIC_MATCHERS = {
            "/login/**",
            "/v3/api-docs/**",
            "/swagger-ui.html",
            "/api/v1/customer/save",
            "/api/v1/task/save",
            "/swagger-ui/**",
            "/h2-console/**"

    };

    private static final String[] ADMIN_MATCHERS = {
            "/api/v1/employee/save",
            "/api/v1/employee/employers",
            "/api/v1/customer/customers"
    };

    @Autowired
    private SecurityFilter securityFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().authorizeHttpRequests()
                .requestMatchers(
                        HttpMethod.POST, PUBLIC_MATCHERS)
                .permitAll()
                .requestMatchers(HttpMethod.GET,PUBLIC_MATCHERS)
                .permitAll()
                .requestMatchers(HttpMethod.POST, ADMIN_MATCHERS).hasRole("ADMIN")
                .requestMatchers(HttpMethod.GET, ADMIN_MATCHERS).hasRole("ADMIN")
                .anyRequest().authenticated()
                .and().addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
                .headers().frameOptions().disable().and()
                .build();

    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
         return configuration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
