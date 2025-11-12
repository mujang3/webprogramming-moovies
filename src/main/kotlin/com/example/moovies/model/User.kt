// Moovies: User 엔티티는 회원 정보를 저장하는 데이터 모델
// Author : Jang Mun-Gyung
// Date : June 18, 2025
// Student ID : 22312047
// 사용자의 이름, 아이디(username), 비밀번호, 권한(role) 및 생성/수정 시간을 포함함

package com.example.moovies.model

import jakarta.persistence.*
import java.time.LocalDateTime

// DB의 users 테이블과 매핑되는 사용자 엔티티
@Entity
@Table(name = "users")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,                           // 사용자 고유 ID (자동 생성)

    @Column(nullable = false, length = 50)
    var name: String = "",                      // 사용자 이름

    @Column(unique = true, nullable = false, length = 50)
    var username: String = "",                  // 로그인용 고유 사용자 아이디

    @Column(nullable = false)
    var password: String = "",                  // 암호화된 비밀번호

    @Column(nullable = false, length = 20)
    var role: String = "ROLE_USER",             // 권한 (기본: 일반 사용자)

    var createdAt: LocalDateTime = LocalDateTime.now(), // 가입 시각
    var updatedAt: LocalDateTime = LocalDateTime.now()  // 정보 수정 시각
)