package com.myou.security.configurations;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @Author myou
 * @Date 2020/8/13  3:20 下午
 * QueryDsl配置类
 */
@Configuration
public class QueryDslConfig {

    @Autowired
    @PersistenceContext
    private EntityManager entityManager;

    @Bean
    public JPAQueryFactory getJpaQueryDsl() {
        return new JPAQueryFactory(entityManager);
    }
}
