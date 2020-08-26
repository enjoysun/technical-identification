package com.myou.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @Author myou
 * @Date 2020/8/3  10:07 上午
 */
@SpringBootApplication
@ComponentScan(basePackages = {
        "com.myou.security.controllers",
        "com.myou.security.services",
        "com.myou.security.configurations"})
@EnableJpaRepositories(basePackages = {"com.myou.security.repositorys"})
@EntityScan(basePackages = "com.myou.security.entities")
@EnableJpaAuditing
public class SecurityApplication {
    public static void main(String[] args) {
        SpringApplication.run(SecurityApplication.class);
    }
}
