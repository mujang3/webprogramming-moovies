// Moovies: Comment 엔티티는 리뷰에 달리는 댓글 정보를 나타냄
// Author : Jang Mun-Gyung
// Date : June 18, 2025
// Student ID : 22312047
// 각 댓글은 특정 리뷰와 사용자(작성자)에 연결됨

package com.example.moovies.model

import jakarta.persistence.*

@Entity
data class Comment(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,                     // 댓글 고유 ID (자동 생성)

    val content: String,                 // 댓글 내용

    @ManyToOne(fetch = FetchType.LAZY)
    val review: Review,                  // 댓글이 달린 리뷰 (N:1 관계)

    @ManyToOne(fetch = FetchType.LAZY)
    val author: User                     // 댓글 작성자 (N:1 관계)
)