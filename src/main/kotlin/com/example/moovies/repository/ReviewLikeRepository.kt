package com.example.moovies.repository

import com.example.moovies.model.Review
import com.example.moovies.model.ReviewLike
import com.example.moovies.model.User
import org.springframework.data.jpa.repository.JpaRepository

interface ReviewLikeRepository : JpaRepository<ReviewLike, Long> {

    fun findByReviewAndUser(review: Review, user: User): ReviewLike?

    fun existsByReviewAndUser(review: Review, user: User): Boolean

    fun countByReview(review: Review): Int
}