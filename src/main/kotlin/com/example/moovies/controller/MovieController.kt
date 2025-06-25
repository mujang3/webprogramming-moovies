// Moovies: MovieController는 영화 상세 페이지 요청을 처리하고 영화 및 리뷰 데이터를 전달하는 Spring MVC 컨트롤러
// Author : Jang Mun-Gyung
// Date : June 18, 2025
// Student ID : 22312047
// 선택한 영화의 정보와 해당 영화에 대한 리뷰 목록을 화면에 전달

package com.example.moovies.controller

import com.example.moovies.service.MovieService
import com.example.moovies.service.ReviewService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@Controller
class MovieController(
    private val reviewService: ReviewService,
    private val movieService: MovieService
) {

    @GetMapping("/movies/{id}")
    fun movieDetail(@PathVariable id: Long, model: Model): String {
        val movie = movieService.getMovie(id)           // 영화 ID로 영화 정보 조회
        val reviews = reviewService.getReviews(id)      // 해당 영화에 대한 리뷰 목록 조회
        model.addAttribute("movie", movie)              // 영화 정보를 모델에 추가
        model.addAttribute("reviews", reviews)          // 리뷰 정보를 모델에 추가
        return "movie_detail"                           // movie_detail.html 렌더링
    }
}