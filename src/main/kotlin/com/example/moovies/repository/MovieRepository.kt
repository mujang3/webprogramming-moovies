// Moovies: MovieRepository는 영화(Movie) 엔티티에 대한 CRUD 처리를 담당하는 JPA 리포지토리 인터페이스
// Author : Jang Mun-Gyung
// Date : June 18, 2025
// Student ID : 22312047
// Spring Data JPA를 통해 Movie 엔티티의 DB 접근을 자동으로 처리

package com.example.moovies.repository

import com.example.moovies.model.Movie
import org.springframework.data.jpa.repository.JpaRepository

// Movie 엔티티를 관리하는 리포지토리
interface MovieRepository : JpaRepository<Movie, Long>