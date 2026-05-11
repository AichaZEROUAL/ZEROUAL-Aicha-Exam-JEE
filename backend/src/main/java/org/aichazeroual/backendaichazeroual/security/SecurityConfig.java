package org.aichazeroual.backendaichazeroual.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http

                .csrf(csrf -> csrf.disable())


                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/h2-console/**").permitAll() // Accès libre à H2 [cite: 22]
                        .requestMatchers("/swagger-ui/**", "/v3/api-docs/**").permitAll() // Accès libre à Swagger [cite: 48]
                        .anyRequest().permitAll() // Pour l'instant, on laisse tout ouvert pour tester ton DAO/Service
                )

                .headers(headers -> headers.frameOptions(frame -> frame.disable()))


                .formLogin(Customizer.withDefaults());

        return http.build();
    }
}
