// Moovies: ReviewRepository는 리뷰(Review) 엔티티에 대한 DB 접근을 처리하는 JPA 리포지토리 인터페이스
// Author : Jang Mun-Gyung
// Date : June 18, 2025
// Student ID : 22312047
// 특정 영화의 리뷰 목록 조회를 포함한 기본적인 CRUD 기능을 제공

package com.example.moovies.repository

import com.example.moovies.model.Review
import org.springframework.data.jpa.repository.JpaRepository

// Review 엔티티를 관리하는 리포지토리
interface ReviewRepository : JpaRepository<Review, Long> {
    // 영화 ID에 해당하는 모든 리뷰를 조회
    fun findAllByMovieId(movieId: Long): List<Review>
}