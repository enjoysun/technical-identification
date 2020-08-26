package com.myou.security.entities;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @Author myou
 * @Date 2020/8/5  5:23 下午
 */
@Entity
@Table(name = "tb_permission", schema = "sercurty_auth")
public class PermissionEntity extends BaseEntity {
    private Long permissionId;

    @Basic
    @Column(name = "permissionName", nullable = true)
    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    private String permissionName;

    @Id
    @Column(name = "permission_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }

    /**
     * ManyToMany关系标注。cascade级联关系，fetch加载策略，mappedBy关系的维系方
     * JoinTable配置中间表（包含两个外键）
     * name中间表名称
     * joinColumns中间表当前对象外键关联配置
     * inverseJoinColumns中间表配置方对象外键关联配置
     * */
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "permission_action",
            joinColumns = {@JoinColumn(name = "sys_permisson_id", referencedColumnName = "permission_id")},
            inverseJoinColumns = {@JoinColumn(name = "sys_action_id", referencedColumnName = "action_id")}
    )
    public Set<ActionEntity> getActionEntities() {
        return actionEntities;
    }

    public void setActionEntities(Set<ActionEntity> actionEntities) {
        this.actionEntities = actionEntities;
    }

    private Set<ActionEntity> actionEntities = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "permission_menu",
            joinColumns = {@JoinColumn(name = "sys_permisson_id", referencedColumnName = "permission_id")},
            inverseJoinColumns = {@JoinColumn(name = "sys_menu_id", referencedColumnName = "menu_id")}
    )
    public Set<MenuEntity> getMenuEntities() {
        return menuEntities;
    }

    public void setMenuEntities(Set<MenuEntity> menuEntities) {
        this.menuEntities = menuEntities;
    }

    private Set<MenuEntity> menuEntities = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PermissionEntity that = (PermissionEntity) o;
        return permissionId == that.permissionId &&
                Objects.equals(permissionName, that.permissionName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(permissionId, permissionName);
    }
}
