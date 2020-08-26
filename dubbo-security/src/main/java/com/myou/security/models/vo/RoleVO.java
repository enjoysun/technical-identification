package com.myou.security.models.vo;

import com.myou.security.models.PageInfo;

import java.util.Set;

/**
 * @Author myou
 * @Date 2020/8/14  10:52 上午
 */
public class RoleVO extends PageInfo {
    private Long roleId;
    private String roleName;
    private Boolean roleNotEnable;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Boolean getRoleNotEnable() {
        return roleNotEnable;
    }

    public void setRoleNotEnable(Boolean roleNotEnable) {
        this.roleNotEnable = roleNotEnable;
    }

    public Set<Long> getRoleRelateID() {
        return roleRelateID;
    }

    public void setRoleRelateID(Set<Long> roleRelateID) {
        this.roleRelateID = roleRelateID;
    }

    private Set<Long> roleRelateID;
}
