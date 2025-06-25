// Moovies: UserRepository는 사용자(User) 엔티티에 대한 DB 접근을 처리하는 JPA 리포지토리 인터페이스
// Author : Jang Mun-Gyung
// Date : June 18, 2025
// Student ID : 22312047
// 사용자 등록 및 로그인 시 사용자 정보를 조회하는 기능을 제공

package com.example.moovies.repository

import com.example.moovies.model.User
import org.springframework.data.jpa.repository.JpaRepository

// User 엔티티를 DB에서 조회, 저장하는 JPA 인터페이스
interface UserRepository : JpaRepository<User, Long> {
    // username으로 사용자 조회 (로그인에 사용됨)
    fun findByUsername(username: String): User?
}