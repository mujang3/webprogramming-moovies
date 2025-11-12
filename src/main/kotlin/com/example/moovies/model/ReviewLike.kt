// Moovies: ReviewLike 엔티티는 리뷰에 대한 사용자의 '좋아요'를 저장함
// Author : Jang Mun-Gyung
// Date : June 18, 2025
// Student ID : 22312047
// 하나의 리뷰에 대해 한 사용자는 한 번만 좋아요를 누를 수 있도록 유니크 제약 설정

package com.example.moovies.model

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(
    name = "review_likes",
    uniqueConstraints = [
        UniqueConstraint(columnNames = ["review_id", "user_id"])
    ]
)
data class ReviewLike(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,                           // 좋아요 고유 ID

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "review_id", nullable = false)
    val review: Review,                         // 좋아요가 눌린 리뷰

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    val user: User,                             // 좋아요를 누른 사용자

    var createdAt: LocalDateTime = LocalDateTime.now()     // 좋아요 누른 시각
)