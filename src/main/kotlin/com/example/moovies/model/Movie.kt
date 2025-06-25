// Moovies: Movie 엔티티는 영화의 상세 정보를 저장하는 데이터 모델
// Author : Jang Mun-Gyung
// Date : June 18, 2025
// Student ID : 22312047
// 영화 제목, 이미지, 비디오, 설명, 오디오 URL 정보를 포함함

package com.example.moovies.model

import jakarta.persistence.*

@Entity
data class Movie(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,                // 영화 고유 ID (자동 생성)

    val title: String,              // 영화 제목
    val imageUrl: String,           // 포스터 이미지 URL
    val videoUrl: String,           // 예고편 영상 URL
    val description: String,        // 영화 설명
    val audioUrl: String? = null    // 오디오 URL (선택 사항)
)