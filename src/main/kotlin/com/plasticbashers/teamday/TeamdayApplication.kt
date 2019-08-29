package com.plasticbashers.teamday

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@SpringBootApplication
class TeamdayApplication

fun main(args: Array<String>) {
	runApplication<TeamdayApplication>(*args)
}
