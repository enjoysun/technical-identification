package com.myou.security.models.dto;

import java.util.List;

/**
 * @Author myou
 * @Date 2020/8/17  3:20 下午
 */
public class RoleDTO {
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

    public List<PermissionDTO> getPermissionDTOList() {
        return permissionDTOList;
    }

    public void setPermissionDTOList(List<PermissionDTO> permissionDTOList) {
        this.permissionDTOList = permissionDTOList;
    }

    private Long roleId;
    private String roleName;
    private Boolean roleNotEnable;
    private List<PermissionDTO> permissionDTOList;
}
