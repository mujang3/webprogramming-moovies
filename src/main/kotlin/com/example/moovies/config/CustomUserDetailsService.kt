package com.example.moovies.service

import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class CustomUserDetailsService(
    private val userService: UserService
) : UserDetailsService {

    override fun loadUserByUsername(username: String): UserDetails {
        val user = userService.findByUsername(username)
            ?: throw UsernameNotFoundException("User not found")

        return org.springframework.security.core.userdetails.User
            .withUsername(user.username)
            .password(user.password)
            .roles("USER")
            .build()
    }
}