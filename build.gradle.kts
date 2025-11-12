plugins {
	id("org.springframework.boot") version "3.3.2"
	id("io.spring.dependency-management") version "1.1.5"
	kotlin("jvm") version "1.9.24"
	kotlin("plugin.spring") version "1.9.24"
	kotlin("plugin.jpa") version "1.9.24"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
	toolchain { languageVersion.set(JavaLanguageVersion.of(17)) }
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-validation")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation(kotlin("reflect"))
	implementation("org.thymeleaf.extras:thymeleaf-extras-springsecurity6")
	implementation("org.springframework.boot:spring-boot-starter-security")

	// ✅ 드라이버 버전 명시 (부트 BOM이 잡아주긴 하지만 컨테이너 빌드 이슈 차단용)
	runtimeOnly("com.mysql:mysql-connector-j:8.3.0")

	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.springframework.security:spring-security-test")
	testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs += "-Xjsr305=strict"
		jvmTarget = "17"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

