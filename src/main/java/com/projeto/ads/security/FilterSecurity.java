package com.projeto.ads.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true)
public class FilterSecurity {

    //Filtrando rotas e bloqueando rotas restritas a usuários logados
    @Bean
    public SecurityFilterChain filtros(HttpSecurity http) throws Exception {

        return http
                .cors(AbstractHttpConfigurer::disable)
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(authorized -> authorized
                        .requestMatchers(HttpMethod.GET, "/auth").permitAll()
                        .requestMatchers(HttpMethod.POST, "/auth").permitAll()
                        .requestMatchers(HttpMethod.POST, "/user").permitAll()
                        .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                        .requestMatchers(
                                "/css/**",
                                "/img/**",
                                "/js/**").permitAll()
                        .anyRequest().authenticated()
                ).formLogin(form ->
                        form.loginPage("/telaLogin")
                                .loginProcessingUrl("/telaLogin")
                                .permitAll()
                ).build();
    }


    //Método para usar na criptografia da senha
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    //Método para fazer a validação de usuário e senha
    @Bean
    public AuthenticationManager gerenciadorAutenticacao(AuthenticationConfiguration configAuht) throws Exception {
        return configAuht.getAuthenticationManager();
    }


}