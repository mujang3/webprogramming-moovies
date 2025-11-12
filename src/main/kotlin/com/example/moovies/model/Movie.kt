// Moovies: Movie 엔티티는 영화의 상세 정보를 저장하는 데이터 모델
// Author : Jang Mun-Gyung
// Date : June 18, 2025
// Student ID : 22312047
// 영화 제목, 이미지, 비디오, 설명, 오디오 URL 및 부가 정보(연도, 장르, 감독, 상영시간)를 포함함

package com.example.moovies.model

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
data class Movie(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,                // 영화 고유 ID (자동 생성)

    @Column(nullable = false)
    var title: String,               // 영화 제목

    @Column(nullable = false)
    var imageUrl: String,            // 포스터 이미지 URL

    @Column(nullable = false)
    var videoUrl: String,            // 예고편 영상 URL

    @Column(nullable = false, columnDefinition = "TEXT")
    var description: String,         // 영화 설명

    var audioUrl: String? = null,    // 오디오 URL (선택 사항)

    var year: Int? = null,           // 개봉 연도 (선택)
    var genre: String? = null,       // 장르 (선택)
    var director: String? = null,    // 감독 (선택)
    var runningTime: Int? = null,    // 상영 시간 (분 단위, 선택)

    var createdAt: LocalDateTime = LocalDateTime.now(), // 등록 시각
    var updatedAt: LocalDateTime = LocalDateTime.now()  // 정보 수정 시각
)