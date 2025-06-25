// Moovies: ReviewService는 영화 리뷰의 생성, 수정, 삭제, 조회, 좋아요 기능을 처리하는 서비스 클래스
// Author : Jang Mun-Gyung
// Date : June 18, 2025
// Student ID : 22312047
// 사용자 권한 확인 후 리뷰에 대한 비즈니스 로직을 실행

package com.example.moovies.service

import com.example.moovies.model.Movie
import com.example.moovies.model.Review
import com.example.moovies.model.User
import com.example.moovies.repository.ReviewRepository
import org.springframework.stereotype.Service

@Service
class ReviewService(
    private val reviewRepository: ReviewRepository
) {
    // 새로운 리뷰 추가
    fun addReview(movie: Movie, content: String, author: User) {
        val review = Review(
            content = content,
            movie = movie,
            author = author
        )
        reviewRepository.save(review)
    }

    // 리뷰 수정 - 작성자만 수정 가능
    fun editReview(reviewId: Long, newContent: String, user: User): Review {
        val review = reviewRepository.findById(reviewId)
            .orElseThrow { RuntimeException("리뷰를 찾을 수 없습니다.") }

        if (review.author.id != user.id) {
            throw RuntimeException("수정 권한이 없습니다.")
        }
        review.content = newContent
        return reviewRepository.save(review)
    }

    // 리뷰 좋아요 기능 (단순히 좋아요 수 증가)
    fun likeReview(reviewId: Long, user: User): Review {
        val review = reviewRepository.findById(reviewId)
            .orElseThrow { RuntimeException("리뷰를 찾을 수 없습니다.") }

        review.likeCount += 1
        return reviewRepository.save(review)
    }

    // 특정 리뷰 조회
    fun getReview(reviewId: Long): Review {
        return reviewRepository.findById(reviewId)
            .orElseThrow { RuntimeException("리뷰를 찾을 수 없습니다.") }
    }

    // 특정 영화에 대한 모든 리뷰 조회
    fun getReviews(movieId: Long): List<Review> {
        return reviewRepository.findAllByMovieId(movieId)
    }

    // 리뷰 삭제 - 작성자만 삭제 가능
    fun deleteReview(reviewId: Long, user: User): Long {
        val review = reviewRepository.findById(reviewId)
            .orElseThrow { RuntimeException("리뷰를 찾을 수 없습니다.") }

        if (review.author.id != user.id) {
            throw RuntimeException("삭제 권한이 없습니다.")
        }

        val movieId = review.movie.id
        reviewRepository.delete(review)
        return movieId
    }
}