// Moovies: CommentController는 영화 리뷰에 대한 댓글 추가 요청을 처리하는 Spring MVC 컨트롤러
// Author : Jang Mun-Gyung
// Date : June 18, 2025
// Student ID : 22312047
// 세션에서 로그인한 사용자만 댓글을 작성할 수 있도록 처리

package com.example.moovies.controller

import com.example.moovies.model.User
import com.example.moovies.service.CommentService
import com.example.moovies.service.ReviewService
import com.example.moovies.service.UserService
import jakarta.servlet.http.HttpSession
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@Controller
class CommentController(
    private val commentService: CommentService,
    private val reviewService: ReviewService,
    private val userService: UserService
) {

    // 댓글 추가 처리 메서드
    @PostMapping("/comments/add")
    fun addComment(
        @RequestParam reviewId: Long,            // 대상 리뷰 ID
        @RequestParam content: String,           // 댓글 내용
        session: HttpSession                     // 세션에서 로그인 사용자 확인용
    ): String {
        // 로그인 사용자 확인 (없으면 로그인 페이지로 리다이렉트)
        val user = session.getAttribute("user") as? User
            ?: return "redirect:/login"

        // 해당 리뷰 가져오기 (리뷰가 속한 영화 정보를 위해 필요)
        val review = reviewService.getReview(reviewId)

        // 댓글 저장 서비스 호출
        commentService.addComment(reviewId, content, user)

        // 댓글이 속한 영화 상세 페이지로 리다이렉트
        return "redirect:/movies/${review.movie.id}"
    }
}