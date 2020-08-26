package com.myou.security.services;

import com.myou.security.entities.MenuEntity;
import com.myou.security.entities.QMenuEntity;
import com.myou.security.models.vo.MenuVO;
import com.myou.security.repositorys.MenuRepository;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @Author myou
 * @Date 2020/8/6  10:14 上午
 */
@Service
public class MenuService {

    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private JPAQueryFactory jpaQueryFactory;

    public MenuEntity save(MenuEntity menuEntity) {
        return menuRepository.save(menuEntity);
    }

    public void deleteById(Long id) {
        menuRepository.deleteById(id);
    }

    public MenuEntity findById(Long id) {
        Optional<MenuEntity> menuEntity = menuRepository.findById(id);
        return menuEntity.orElseGet(() -> null);
    }

    public List<MenuEntity> findByEx(MenuVO menuVO) {
        QMenuEntity entity = QMenuEntity.menuEntity;
        BooleanBuilder builder = new BooleanBuilder();
        if (!StringUtils.isEmpty(menuVO.getMenuName())) {
            builder.and(entity.menuName.like(String.format("%%%s%%", menuVO.getMenuName())));
        }
        if (!StringUtils.isEmpty(menuVO.getMenuUrl())) {
            builder.and(entity.menuUrl.like(String.format("%%%s%%", menuVO.getMenuUrl())));
        }
        JPAQuery<MenuEntity> jpaQuery = jpaQueryFactory.selectFrom(entity)
                .offset(menuVO.pageNumber())
                .limit(menuVO.getPageSize())
                .where(builder);
        return jpaQuery.fetch();
    }
}
