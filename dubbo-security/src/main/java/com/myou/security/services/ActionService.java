package com.myou.security.services;

import com.myou.security.entities.ActionEntity;
import com.myou.security.entities.MenuEntity;
import com.myou.security.entities.QActionEntity;
import com.myou.security.entities.QMenuEntity;
import com.myou.security.models.vo.ActionVO;
import com.myou.security.repositorys.ActionRepository;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author myou
 * @Date 2020/8/5  10:49 上午
 */
@Service
public class ActionService {

    @Autowired
    private ActionRepository actionRepository;

    @Autowired
    private JPAQueryFactory jpaQueryFactory;

    public ActionEntity save(ActionEntity entity) {
        return actionRepository.save(entity);
    }

    public List<ActionEntity> saveAll(List<ActionEntity> entities) {
        return actionRepository.saveAll(entities);
    }

    public void deleteById(Long id) {
        actionRepository.deleteById(id);
    }

    public List<ActionEntity> findAll(int pageIndex, int pageSize) {
        Page<ActionEntity> page = actionRepository.findAll(PageRequest.of(pageIndex, pageSize, Sort.Direction.DESC));
        return page.getContent();
    }

    public ActionEntity findByActionUrl(String url) {
        return actionRepository.findFirstByActionUrl(url);
    }

    public ActionEntity findByActionName(String name) {
        return actionRepository.findFirstByActionName(name);
    }

    public ActionEntity findById(Long id) {
        return actionRepository.findByActionId(id);
    }

    public boolean existsByEntity(Long id, String url, String name) {
        ActionEntity entity = new ActionEntity();
        entity.setActionId(id);
        entity.setActionUrl(url);
        entity.setActionName(name);
        Example<ActionEntity> example = Example.of(entity);
        return actionRepository.exists(example);
    }

    public boolean exists(Long id) {
        return actionRepository.existsById(id);
    }

    public List<ActionEntity> findByEx(ActionVO actionVO) {
        QActionEntity actionEntity = QActionEntity.actionEntity;
        BooleanBuilder builder = new BooleanBuilder();
        if (!StringUtils.isEmpty(actionVO.getActionName())) {
            builder.and(actionEntity.actionName.like(String.format("%%%s%%", actionVO.getActionName())));
        }
        if (!StringUtils.isEmpty(actionVO.getActionUrl())) {
            builder.and(actionEntity.actionUrl.like(String.format("%%%s%%", actionVO.getActionUrl())));
        }
        JPAQuery<ActionEntity> jpaQuery = jpaQueryFactory.selectFrom(actionEntity)
                .offset(actionVO.pageNumber())
                .limit(actionVO.getPageSize())
                .where(builder);
        return jpaQuery.fetch();
    }

}
