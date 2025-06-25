// Moovies: ReviewController는 영화에 대한 리뷰 작성, 수정, 삭제, 좋아요 기능을 처리하는 Spring MVC 컨트롤러
// Author : Jang Mun-Gyung
// Date : June 18, 2025
// Student ID : 22312047
// 세션에서 로그인된 사용자 정보를 사용하여 리뷰 관련 요청을 처리

package com.example.moovies.controller

import com.example.moovies.model.User
import com.example.moovies.service.MovieService
import com.example.moovies.service.ReviewService
import jakarta.servlet.http.HttpSession
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@Controller
class ReviewController(
    private val reviewService: ReviewService,
    private val movieService: MovieService
) {

    // 리뷰 작성 처리
    @PostMapping("/reviews/add")
    fun addReview(
        @RequestParam movieId: Long,
        @RequestParam content: String,
        session: HttpSession
    ): String {
        val user = session.getAttribute("user") as? User ?: return "redirect:/login"
        val movie = movieService.getMovie(movieId)

        return try {
            reviewService.addReview(movie, content, user)     // 리뷰 추가 서비스 호출
            "redirect:/movies/$movieId"                        // 영화 상세 페이지로 리디렉션
        } catch (e: Exception) {
            println("리뷰 작성 실패: ${e.message}")
            "redirect:/movies/$movieId?error=review"          // 에러 발생 시 영화 페이지로 이동
        }
    }

    // 리뷰 수정 처리
    @PostMapping("/reviews/edit")
    fun editReview(
        @RequestParam reviewId: Long,
        @RequestParam content: String,
        session: HttpSession
    ): String {
        val user = session.getAttribute("user") as? User ?: return "redirect:/login"

        return try {
            val updated = reviewService.editReview(reviewId, content, user)   // 리뷰 수정
            "redirect:/movies/${updated.movie.id}"                            // 수정된 영화 페이지로 이동
        } catch (e: Exception) {
            println("리뷰 수정 실패: ${e.message}")
            "redirect:/"                                                      // 실패 시 홈으로 이동
        }
    }

    // 리뷰 삭제 처리
    @PostMapping("/reviews/delete")
    fun deleteReview(
        @RequestParam reviewId: Long,
        session: HttpSession
    ): String {
        val user = session.getAttribute("user") as? User ?: return "redirect:/login"

        return try {
            val movieId = reviewService.deleteReview(reviewId, user)          // 리뷰 삭제
            "redirect:/movies/$movieId"                                       // 영화 페이지로 리디렉션
        } catch (e: Exception) {
            println("❌ 리뷰 삭제 실패: ${e.message}")
            "redirect:/"                                                      // 실패 시 홈으로 이동
        }
    }

    // 리뷰 좋아요 처리
    @PostMapping("/reviews/like")
    fun likeReview(
        @RequestParam reviewId: Long,
        session: HttpSession
    ): String {
        val user = session.getAttribute("user") as? User ?: return "redirect:/login"

        return try {
            val updated = reviewService.likeReview(reviewId, user)            // 좋아요 처리
            "redirect:/movies/${updated.movie.id}"                            // 영화 페이지로 리디렉션
        } catch (e: Exception) {
            println("❌ 좋아요 실패: ${e.message}")
            "redirect:/"                                                      // 실패 시 홈으로 이동
        }
    }
}