package com.myou.security.enums;

public enum PermissionEnum {
    MENU_PERMISSION(1), //菜单类型权限
    ACTION_PERMISSION(2); //接口类型权限

    private int status;

    PermissionEnum(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
}
