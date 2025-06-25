// Moovies: User 엔티티는 회원 정보를 저장하는 데이터 모델
// Author : Jang Mun-Gyung
// Date : June 18, 2025
// Student ID : 22312047
// 사용자의 이름, 아이디(username), 비밀번호를 포함하고 있으며 DB의 users 테이블과 매핑됨

package com.example.moovies.model

import jakarta.persistence.*

// DB의 users 테이블과 매핑되는 사용자 엔티티
@Entity
@Table(name = "users")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,                           // 사용자 고유 ID (자동 생성)

    @Column(nullable = false)
    var name: String = "",                      // 사용자 이름

    @Column(unique = true, nullable = false)
    var username: String = "",                  // 로그인용 고유 사용자 아이디

    @Column(nullable = false)
    var password: String = ""                   // 암호화된 비밀번호
)