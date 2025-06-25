package com.example.moovies.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain

@Configuration
class SecurityConfig {

    @Bean
    fun passwordEncoder(): PasswordEncoder = BCryptPasswordEncoder()

    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .authorizeHttpRequests {
                it.requestMatchers("/login", "/register", "/css/**", "/js/**", "/images/**").permitAll()
                    .anyRequest().permitAll()
            }
            .csrf { it.disable() }
            .headers { it.frameOptions { frame -> frame.disable() } }
            .logout { it.logoutSuccessUrl("/login") }

        return http.build()
    }
}