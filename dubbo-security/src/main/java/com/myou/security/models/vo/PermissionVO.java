package com.myou.security.models.vo;

import com.myou.security.enums.PermissionEnum;
import com.myou.security.models.PageInfo;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author myou
 * @Date 2020/8/6  11:10 上午
 */
public class PermissionVO extends PageInfo {
    private Long permissionId;

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    private String permissionName;
    private Set<Long> menuRelatedId;

    public Set<Long> getActionRelatedId() {
        return actionRelatedId;
    }

    public void setActionRelatedId(Set<Long> actionRelatedId) {
        this.actionRelatedId = actionRelatedId;
    }

    private Set<Long> actionRelatedId;

    public Set<Long> getMenuRelatedId() {
        return menuRelatedId;
    }

    public void setMenuRelatedId(Set<Long> menuRelatedId) {
        this.menuRelatedId = menuRelatedId;
    }



    public Long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }
}
