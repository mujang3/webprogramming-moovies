// Moovies: CommentService는 리뷰에 대한 댓글 추가 로직을 처리하는 서비스 클래스
// Author : Jang Mun-Gyung
// Date : June 18, 2025
// Student ID : 22312047
// 리뷰 ID를 기반으로 댓글을 저장하고, 작성자 정보를 함께 등록함

package com.example.moovies.service

import com.example.moovies.model.Comment
import com.example.moovies.model.User
import com.example.moovies.repository.CommentRepository
import com.example.moovies.repository.ReviewRepository
import org.springframework.stereotype.Service

@Service
class CommentService(
    private val commentRepo: CommentRepository,       // 댓글 저장소
    private val reviewRepo: ReviewRepository          // 리뷰 저장소
) {
    // 주어진 리뷰 ID와 사용자, 댓글 내용을 기반으로 댓글을 추가하는 함수
    fun addComment(reviewId: Long, content: String, author: User) {
        val review = reviewRepo.findById(reviewId)
            .orElseThrow { IllegalArgumentException("리뷰를 찾을 수 없습니다. id=$reviewId") }

        val comment = Comment(
            content = content,
            review = review,
            author = author
        )

        commentRepo.save(comment) // DB에 저장
    }
}