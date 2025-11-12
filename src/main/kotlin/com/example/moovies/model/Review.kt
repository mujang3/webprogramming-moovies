// Moovies: Review 엔티티는 영화 리뷰 정보를 저장하는 데이터 모델
// Author : Jang Mun-Gyung
// Date : June 18, 2025
// Student ID : 22312047
// 리뷰 내용, 작성자, 댓글, 좋아요 수 및 생성/수정 시간을 포함함

package com.example.moovies.model

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
data class Review(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,                       // 리뷰 고유 ID (자동 생성)

    @Column(nullable = false, columnDefinition = "TEXT")
    var content: String,                    // 리뷰 내용

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id", nullable = false)
    val movie: Movie,                      // 리뷰가 작성된 영화

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id", nullable = false)
    val author: User,                      // 리뷰 작성자

    @OneToMany(mappedBy = "review", cascade = [CascadeType.ALL], orphanRemoval = true)
    val comments: MutableList<Comment> = mutableListOf(),  // 해당 리뷰에 달린 댓글 목록

    @OneToMany(mappedBy = "review", cascade = [CascadeType.ALL], orphanRemoval = true)
    val likes: MutableList<ReviewLike> = mutableListOf(),  // 해당 리뷰에 달린 좋아요 목록

    var likeCount: Int = 0,                // 리뷰 좋아요 수 (캐시 용도)

    var createdAt: LocalDateTime = LocalDateTime.now(),    // 리뷰 작성 시각
    var updatedAt: LocalDateTime = LocalDateTime.now()     // 리뷰 수정 시각
)