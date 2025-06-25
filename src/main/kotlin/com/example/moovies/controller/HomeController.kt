// Moovies: HomeController는 홈페이지 요청을 처리하고 전체 영화 목록을 전달하는 Spring MVC 컨트롤러
// Author : Jang Mun-Gyung
// Date : June 18, 2025
// Student ID : 22312047
// 데이터베이스에서 영화 정보를 조회하여 홈 화면에 표시

package com.example.moovies.controller

import com.example.moovies.service.MovieService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class HomeController(private val movieService: MovieService) {

    @GetMapping("/")
    fun home(model: Model): String {
        val movies = movieService.getAllMovies() // 영화 목록을 데이터베이스에서 가져옴
        model.addAttribute("movies", movies)     // 모델에 영화 리스트 추가
        return "home"                            // home.html 렌더링
    }
}