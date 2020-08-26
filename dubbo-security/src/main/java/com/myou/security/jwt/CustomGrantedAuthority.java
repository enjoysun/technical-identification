package com.myou.security.jwt;

import com.myou.security.entities.RoleEntity;
import com.myou.security.models.dto.RoleDTO;
import org.springframework.security.core.GrantedAuthority;

/**
 * @Author myou
 * @Date 2020/8/17  3:19 下午
 */
public class CustomGrantedAuthority implements GrantedAuthority {

    private RoleEntity roleDTO;

    public CustomGrantedAuthority(RoleEntity role) {
        this.roleDTO = role;
    }

    @Override
    public String getAuthority() {
        return roleDTO.getRoleName();
    }
}
