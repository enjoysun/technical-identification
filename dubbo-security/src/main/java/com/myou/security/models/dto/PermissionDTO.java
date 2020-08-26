package com.myou.security.models.dto;


import java.util.List;

/**
 * @Author myou
 * @Date 2020/8/10  4:42 下午
 */
public class PermissionDTO {
    private Long permissionId;
    private int permissionType;
    private List<ActionDTO> actionDTOS;

    public Long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }

    public int getPermissionType() {
        return permissionType;
    }

    public void setPermissionType(int permissionType) {
        this.permissionType = permissionType;
    }

    public List<ActionDTO> getActionDTOS() {
        return actionDTOS;
    }

    public void setActionDTOS(List<ActionDTO> actionDTOS) {
        this.actionDTOS = actionDTOS;
    }

    public List<MenuDTO> getMenuDTOS() {
        return menuDTOS;
    }

    public void setMenuDTOS(List<MenuDTO> menuDTOS) {
        this.menuDTOS = menuDTOS;
    }

    private List<MenuDTO> menuDTOS;
}
