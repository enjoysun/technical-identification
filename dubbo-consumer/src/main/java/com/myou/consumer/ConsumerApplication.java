package com.myou.consumer;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

/**
 * @Author myou
 * @Date 2020/7/31  4:33 下午
 */
@SpringBootApplication
@PropertySource("classpath:dubbo.properties")
@EnableDubbo(scanBasePackages = {"com.myou.consumer.service"})
public class ConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }
}
