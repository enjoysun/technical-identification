package com.myou.security.services;

import com.myou.security.entities.PermissionEntity;
import com.myou.security.entities.QPermissionEntity;
import com.myou.security.entities.QRoleEntity;
import com.myou.security.entities.RoleEntity;
import com.myou.security.exceptions.DataUpdatePrimaryIsEmptyException;
import com.myou.security.models.vo.RoleVO;
import com.myou.security.persistence.Constants;
import com.myou.security.repositorys.RoleRepository;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * @Author myou
 * @Date 2020/8/13  5:03 下午
 */
@Service
public class RoleService {

    /**
     * 1.角色新增、删除、修改
     * 2.角色查询(包含关联权限列表)
     */

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private JPAQueryFactory jpaQueryFactory;


    @Transactional(propagation = Propagation.REQUIRED)
    public RoleEntity roleCreate(RoleVO roleVO) {
        Set<Long> relateID = roleVO.getRoleRelateID();
        QPermissionEntity permissionEntity = QPermissionEntity.permissionEntity;
        List<PermissionEntity> permissionEntities = jpaQueryFactory.selectFrom(permissionEntity).where(permissionEntity.permissionId.in(relateID)).fetch();
        RoleEntity roleEntity = new RoleEntity();
        Constants.copy(roleVO, roleEntity);
        roleEntity.setPermissionEntitySet(new HashSet<>(permissionEntities));
        return roleRepository.save(roleEntity);
    }

    public RoleEntity roleUpdate(RoleVO roleVO) {
        if (null == roleVO.getRoleId()) {
            throw new DataUpdatePrimaryIsEmptyException("primary is empty,can not get instance");
        }
        return this.roleCreate(roleVO);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void roleDelete(Long id) {
        Optional<RoleEntity> optional = roleRepository.findById(id);
        if (optional.isPresent()) {
            RoleEntity roleEntity = optional.get();
            roleEntity.getPermissionEntitySet().clear();
            roleRepository.delete(roleEntity);
        }
    }

    public List<RoleEntity> roleFindByEx(RoleVO roleVO) {
        QRoleEntity qRoleEntity = QRoleEntity.roleEntity;
        BooleanBuilder booleanBuilder = new BooleanBuilder();
        if (!StringUtils.isEmpty(roleVO.getRoleName())) {
            booleanBuilder.and(qRoleEntity.roleName.like(String.format("%%%s%%", roleVO.getRoleName())));
        }
        if (null != roleVO.getRoleId()) {
            booleanBuilder.and(qRoleEntity.roleId.eq(roleVO.getRoleId()));
        }
        if (null != roleVO.getRoleNotEnable()) {
            booleanBuilder.and(qRoleEntity.roleNotEnable.eq(roleVO.getRoleNotEnable()));
        }
        if (null != roleVO.getRoleId()) {
            booleanBuilder.and(qRoleEntity.roleId.eq(roleVO.getRoleId()));
        }
        return jpaQueryFactory.selectFrom(qRoleEntity).offset(roleVO.pageNumber()).limit(roleVO.getPageIndex()).where(booleanBuilder).fetch();
    }

    public RoleEntity findById(Long id) {
        return roleRepository.findById(id).orElseGet(null);
    }

}
