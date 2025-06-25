package com.example.moovies

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MooviesApplication

fun main(args: Array<String>) {
	runApplication<MooviesApplication>(*args)
}
