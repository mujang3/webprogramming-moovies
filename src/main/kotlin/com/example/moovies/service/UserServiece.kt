// Moovies: UserService는 사용자 인증, 회원가입, 사용자 조회 등의 기능을 제공하는 서비스 클래스
// Author : Jang Mun-Gyung
// Date : June 18, 2025
// Student ID : 22312047
// 비밀번호 암호화 및 사용자 인증 로직을 포함

package com.example.moovies.service

import com.example.moovies.model.User
import com.example.moovies.repository.UserRepository
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

// 사용자 등록/조회 로직을 처리하는 서비스 클래스
@Service
class UserService(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder
) {

    // 로그인 처리: 사용자 존재 여부 및 비밀번호 검증
    fun login(username: String, password: String): User? {
        val user = userRepository.findByUsername(username) ?: return null
        return if (passwordEncoder.matches(password, user.password)) user else null
    }

    // 회원가입: 비밀번호 암호화 후 저장
    fun register(user: User) {
        // role, createdAt/updatedAt은 엔티티 기본값 사용
        user.password = passwordEncoder.encode(user.password)
        userRepository.save(user)
    }

    // 사용자 이름으로 조회 (로그인용)
    fun findByUsername(username: String): User? {
        return userRepository.findByUsername(username)
    }
}