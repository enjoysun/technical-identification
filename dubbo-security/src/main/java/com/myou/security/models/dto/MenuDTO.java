package com.myou.security.models.dto;

/**
 * @Author myou
 * @Date 2020/8/17  3:33 下午
 */
public class MenuDTO {
    private Long menuId;
    private String menuName;

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    private String menuUrl;
}
