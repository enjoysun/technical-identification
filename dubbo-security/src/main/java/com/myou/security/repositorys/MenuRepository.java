package com.myou.security.repositorys;

import com.myou.security.entities.MenuEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;

/**
 * @Author myou
 * @Date 2020/8/5  10:25 上午
 */
public interface MenuRepository extends JpaRepository<MenuEntity, Long> , QuerydslPredicateExecutor<MenuEntity> {
    public List<MenuEntity> findByMenuNameLike(String menuName);
}
