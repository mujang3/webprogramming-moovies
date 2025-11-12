// Moovies: MovieService는 영화 정보를 데이터베이스에서 조회하는 서비스 클래스
// Author : Jang Mun-Gyung
// Date : June 18, 2025
// Student ID : 22312047
// 영화 단건 조회 및 전체 목록 조회 기능을 제공함

package com.example.moovies.service

import com.example.moovies.model.Movie
import com.example.moovies.repository.MovieRepository
import org.springframework.stereotype.Service

@Service
class MovieService(
    private val movieRepository: MovieRepository
) {

    // 특정 ID를 가진 영화 한 편을 반환 (없을 경우 예외 발생)
    fun getMovie(id: Long): Movie {
        return movieRepository.findById(id)
            .orElseThrow { IllegalArgumentException("영화를 찾을 수 없습니다. id=$id") }
    }

    // 영화 전체 목록 조회
    fun getAllMovies(): List<Movie> = movieRepository.findAll()
}