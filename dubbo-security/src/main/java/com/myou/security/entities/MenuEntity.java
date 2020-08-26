package com.myou.security.entities;

import javax.persistence.*;
import java.util.Objects;

/**
 * @Author myou
 * @Date 2020/8/5  5:23 下午
 */
@Entity
@Table(name = "tb_menu", schema = "sercurty_auth", catalog = "")
public class MenuEntity extends BaseEntity {
    private Long menuId;
    private String menuName;
    private String menuUrl;

    @Id
    @Column(name = "menu_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    @Basic
    @Column(name = "menu_name", nullable = false, length = 32)
    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    @Basic
    @Column(name = "menu_url", nullable = false, length = 128)
    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MenuEntity that = (MenuEntity) o;
        return menuId == that.menuId &&
                Objects.equals(menuName, that.menuName) &&
                Objects.equals(menuUrl, that.menuUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(menuId, menuName, menuUrl);
    }
}
