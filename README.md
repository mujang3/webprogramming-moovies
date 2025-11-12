# 🎬 Moovies

**Moovies**는 사용자가 영화 정보를 탐색하고, 리뷰를 작성·수정·삭제하며, 좋아요를 남길 수 있는  
**React + Spring Boot 기반 영화 리뷰 웹 애플리케이션**입니다.  
Thymeleaf 템플릿을 제거하고 React 프론트엔드와 REST API 기반의 백엔드(Spring Boot)를 분리하여  
확장성과 유지보수성을 높였습니다.

---

## 🚀 주요 기능

| 구분 | 기능 | 설명 |
|------|------|------|
| 🎥 **영화 목록 보기** | 등록된 영화의 포스터, 제목, 장르, 평점, 조회수를 표시 |
| 🔍 **영화 상세 페이지** | 선택한 영화의 상세 정보, 예고편 영상, 리뷰 목록 표시 |
| ✍️ **리뷰 관리** | 사용자가 로그인 후 리뷰 작성, 수정, 삭제 가능 |
| ❤️ **리뷰 좋아요** | 다른 사용자의 리뷰에 ‘좋아요’ 기능 제공 |
| ⭐ **평점 평가** | 별점(1~5점)을 통해 영화 평가 |
| 🔑 **회원 인증** | JWT 기반 로그인 / 회원가입 기능 |
| 🧭 **검색 및 정렬** | 영화 제목, 장르, 평점 기준으로 검색 및 정렬 가능 |
| 🖼️ **멀티미디어 지원** | 포스터, 예고편 영상 등 이미지/비디오 출력 가능 |

---

## 🧱 시스템 아키텍처

```text
React (Frontend)
   ↓ REST API 통신 (Axios)
Spring Boot (Backend)
   ↓
MySQL Database
```
---

## 🛠️ 기술 스택

| 계층 | 기술 스택 |
|------|-------------|
| **Frontend** | React 18, TypeScript, React-Bootstrap, Axios |
| **Backend** | Spring Boot 3.x, Spring Web, Spring Data JPA |
| **Database** | MySQL 8.x |
| **Authentication** | JWT (JSON Web Token) |
| **Build Tool** | Gradle |
| **Deployment** | Docker, Docker Compose |
| **Version Control** | Git & GitHub |

---

## 📂 디렉토리 구조
```text
moovies/
├── backend/
│   ├── src/main/java/com/example/moovies/
│   │   ├── controller/
│   │   ├── service/
│   │   ├── repository/
│   │   ├── entity/
│   │   └── MooviesApplication.java
│   └── src/main/resources/
│       ├── application.yml
│       └── static/, templates/ (필요 시)
│
├── frontend/
│   ├── src/
│   │   ├── components/
│   │   ├── pages/
│   │   ├── api/
│   │   ├── styles/
│   │   └── App.tsx
│   └── package.json
│
└── docker-compose.yml
```

---

## 💻 실행 방법

### 1️⃣ 백엔드(Spring Boot)
```bash
cd backend
./gradlew bootRun
```
### 2️⃣ 백엔드(Spring Boot)
```bash
cd frontend
npm install
npm start
```
→ 브라우저에서 http://localhost:3000 접속

### ⚙️ 환경 설정 (application.yml)
```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/moovies?serverTimezone=Asia/Seoul
    username: root
    password: yourpassword
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
    properties:
      hibernate:
        format_sql: true
server:
  port: 8080
```

---
