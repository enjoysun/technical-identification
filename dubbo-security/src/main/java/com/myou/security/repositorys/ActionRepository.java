package com.myou.security.repositorys;

import com.myou.security.entities.ActionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;


public interface ActionRepository extends JpaRepository<ActionEntity, Long> , QuerydslPredicateExecutor<ActionEntity> {
    ActionEntity findByActionId(Long id);

    ActionEntity findFirstByActionUrl(String url);

    ActionEntity findFirstByActionName(String name);
}
