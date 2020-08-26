package com.myou.security.repositorys;

import com.myou.security.entities.PermissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface PermissionRepository extends JpaRepository<PermissionEntity, Long> , QuerydslPredicateExecutor<PermissionEntity> {
}
