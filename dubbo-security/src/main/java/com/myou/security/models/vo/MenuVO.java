package com.myou.security.models.vo;

import com.myou.security.models.PageInfo;

/**
 * @Author myou
 * @Date 2020/8/12  3:43 下午
 */
public class MenuVO extends PageInfo {
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

    private Long menuId;
    private String menuName;
    private String menuUrl;
}
