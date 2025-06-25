// Moovies: CommentRepository는 댓글(Comment) 엔티티에 대한 CRUD 처리를 담당하는 JPA 리포지토리 인터페이스
// Author : Jang Mun-Gyung
// Date : June 18, 2025
// Student ID : 22312047
// Spring Data JPA를 통해 Comment 엔티티의 DB 접근을 간단하게 처리

package com.example.moovies.repository

import com.example.moovies.model.Comment
import org.springframework.data.jpa.repository.JpaRepository

// Comment 엔티티를 관리하는 리포지토리
interface CommentRepository : JpaRepository<Comment, Long>