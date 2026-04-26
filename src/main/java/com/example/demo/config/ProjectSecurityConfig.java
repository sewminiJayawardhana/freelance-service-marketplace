package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable()) // CSRF disable කරන්න (Testing ලේසි වෙන්න)
                .authorizeHttpRequests(requests -> requests
                        .requestMatchers("/api/auth/register").permitAll() // Registration එකට ඕනෑම කෙනෙක්ට එන්න ඉඩ දෙන්න
                        .anyRequest().authenticated()); // අනෙක් හැම එකකටම password ඕනේ
        return http.build();
    }
}