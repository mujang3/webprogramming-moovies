package com.example.moovies.controller

import com.example.moovies.model.User
import com.example.moovies.service.UserService
import jakarta.servlet.http.HttpServletRequest
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

@Controller
class AuthController(
    private val userService: UserService
) {

    // 🔐 로그인 페이지 표시
    @GetMapping("/login")
    fun login(): String = "login"

    // ✅ 로그인 처리
    @PostMapping("/login")
    fun login(
        @RequestParam username: String,
        @RequestParam password: String,
        request: HttpServletRequest
    ): String {
        println("로그인 시도: $username / $password")

        val user = userService.login(username, password)
            ?: return "redirect:/login?error"

        println("로그인 성공: ${user.username}")
        println("세션 ID after login: ${request.session.id}")
        request.session.setAttribute("user", user)
        return "redirect:/"
    }

    // 📝 회원가입 폼 페이지
    @GetMapping("/register")
    fun registerForm(model: Model): String {
        model.addAttribute("user", User())
        return "register"
    }

    // 📝 회원가입 처리
    @PostMapping("/register")
    fun register(
        @ModelAttribute user: User,
        request: HttpServletRequest,
        model: Model
    ): String {
        val confirmPassword = request.getParameter("confirmPassword")

        if (user.password != confirmPassword) {
            model.addAttribute("user", user)
            model.addAttribute("error", "비밀번호가 일치하지 않습니다.")
            return "register"
        }

        userService.register(user)
        return "redirect:/login"
    }
}