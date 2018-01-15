package com.vestasoft.proxynator

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.web.support.SpringBootServletInitializer

@SpringBootApplication
@EnableAutoConfiguration
open class Application: SpringBootServletInitializer(){

    @Override
    override fun configure(application: SpringApplicationBuilder?): SpringApplicationBuilder {
        return super.configure(application)
    }
}

    fun main(args: Array<String>) {
        SpringApplication.run(Application::class.java, *args)
    }