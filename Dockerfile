# ---------- Build stage ----------
FROM gradle:8.9-jdk17 AS builder
WORKDIR /app

# Gradle 캐시 활용
COPY gradle gradle
COPY gradlew .
COPY settings.gradle* .
COPY build.gradle* .
RUN chmod +x gradlew
RUN ./gradlew --version

# 소스 복사 후 빌드
COPY . .
RUN ./gradlew clean bootJar -x test --no-daemon --stacktrace --info

# ---------- Run stage ----------
FROM eclipse-temurin:17-jre-jammy
WORKDIR /app
RUN ln -fs /usr/share/zoneinfo/Asia/Seoul /etc/localtime
COPY --from=builder /app/build/libs/*.jar app.jar
EXPOSE 8080
ENV SPRING_PROFILES_ACTIVE=prod
ENTRYPOINT ["java","-jar","/app/app.jar"]