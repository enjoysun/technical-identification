package com.myou.security.services;

import com.myou.security.entities.ActionEntity;
import com.myou.security.entities.MenuEntity;
import com.myou.security.entities.PermissionEntity;
import com.myou.security.entities.QPermissionEntity;
import com.myou.security.enums.PermissionEnum;
import com.myou.security.exceptions.PermissionOperationException;
import com.myou.security.models.vo.PermissionVO;
import com.myou.security.repositorys.ActionRepository;
import com.myou.security.repositorys.MenuRepository;
import com.myou.security.repositorys.PermissionRepository;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @Author myou
 * @Date 2020/8/6  10:52 上午
 */
@Service
public class PermissionService {

    @Autowired
    private PermissionRepository permissionRepository;

    @Autowired
    private ActionRepository actionRepository;

    @Autowired
    private MenuRepository menuRepository;

    @Transactional(propagation = Propagation.REQUIRED)
    public List<PermissionEntity> permissionCreate(List<PermissionVO> permissionVOS) {
        List<PermissionEntity> list = new ArrayList<>();
        for (PermissionVO permissionVO : permissionVOS) {
            PermissionEntity permissionEntity = new PermissionEntity();
            permissionEntity.setPermissionName(permissionVO.getPermissionName());
            this.permissionTypeHandler(permissionEntity, permissionVO);
            list.add(permissionEntity);
        }
        return permissionRepository.saveAll(list);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public PermissionEntity permissionUpdate(PermissionVO permissionVO) {
        Optional<PermissionEntity> optional = permissionRepository.findById(permissionVO.getPermissionId());
        if (optional.isPresent()) {
            PermissionEntity permissionEntity = optional.get();
            permissionEntity.setPermissionName(permissionVO.getPermissionName());
            permissionEntity.setPermissionId(permissionVO.getPermissionId());
            this.permissionTypeHandler(permissionEntity, permissionVO);
            return permissionRepository.save(permissionEntity);
        }
        return null;
    }

    private void permissionTypeHandler(PermissionEntity permissionEntity, PermissionVO permissionVO) {
        Set<Long> actionRelateId = permissionVO.getActionRelatedId();
        List<ActionEntity> actionEntityList = actionRepository.findAllById(actionRelateId);
        permissionEntity.setActionEntities(new HashSet<>(actionEntityList));
        Set<Long> menuRelatedId = permissionVO.getMenuRelatedId();
        List<MenuEntity> menuEntityList = menuRepository.findAllById(menuRelatedId);
        permissionEntity.setMenuEntities(new HashSet<>(menuEntityList));
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public boolean permissionDestroy(Long permissionID) {
        PermissionEntity entity = permissionRepository.getOne(permissionID);
        // 关于多对多关系删除(只删除关系维护方，被维护方无需删除)
        entity.getActionEntities().clear();
        entity.getMenuEntities().clear();
        permissionRepository.delete(entity);
        return true;
    }

    public PermissionEntity permissionFind(Long id) {
        return permissionRepository.findById(id).orElseGet(null);
    }

    public List<PermissionEntity> permissionFindList(List<Long> list) {
        List<PermissionEntity> result = new ArrayList<>();
        QPermissionEntity permissionEntity = QPermissionEntity.permissionEntity;
        BooleanExpression expression = permissionEntity.permissionId.in(list);
        permissionRepository.findAll(expression).forEach(result::add);
        return result;
    }

}
