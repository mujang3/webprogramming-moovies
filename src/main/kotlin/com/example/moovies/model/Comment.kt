// Moovies: Comment 엔티티는 리뷰에 달리는 댓글 정보를 나타냄
// Author : Jang Mun-Gyung
// Date : June 18, 2025
// Student ID : 22312047
// 각 댓글은 특정 리뷰와 사용자(작성자)에 연결되며, 생성/수정 시간을 포함함

package com.example.moovies.model

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
data class Comment(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,                     // 댓글 고유 ID (자동 생성)

    @Column(nullable = false, columnDefinition = "TEXT")
    var content: String,                  // 댓글 내용

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "review_id", nullable = false)
    val review: Review,                   // 댓글이 달린 리뷰 (N:1 관계)

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id", nullable = false)
    val author: User,                     // 댓글 작성자 (N:1 관계)

    var createdAt: LocalDateTime = LocalDateTime.now(),    // 댓글 작성 시각
    var updatedAt: LocalDateTime = LocalDateTime.now()     // 댓글 수정 시각
)