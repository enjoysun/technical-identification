package com.myou.security.entities;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

/**
 * @Author myou
 * @Date 2020/8/5  5:23 下午
 */
@Entity
@Table(name = "tb_role", schema = "sercurty_auth", catalog = "")
public class RoleEntity extends BaseEntity {
    private Long roleId;
    private String roleName;
    private Boolean roleNotEnable;

    @Id
    @Column(name = "role_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    @Basic
    @Column(name = "role_name", nullable = false, length = 64)
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Basic
    @Column(name = "role_not_enable", nullable = false)
    public Boolean getRoleNotEnable() {
        return roleNotEnable;
    }

    public void setRoleNotEnable(Boolean roleNotEnable) {
        this.roleNotEnable = roleNotEnable;
    }

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "role_permission",
            joinColumns = {@JoinColumn(name = "sys_role_id", referencedColumnName = "role_id")},
            inverseJoinColumns = {@JoinColumn(name = "sys_permission_id", referencedColumnName = "permission_id")}
    )
    public Set<PermissionEntity> getPermissionEntitySet() {
        return permissionEntitySet;
    }

    public void setPermissionEntitySet(Set<PermissionEntity> permissionEntitySet) {
        this.permissionEntitySet = permissionEntitySet;
    }

    private Set<PermissionEntity> permissionEntitySet;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoleEntity that = (RoleEntity) o;
        return roleId == that.roleId &&
                roleNotEnable == that.roleNotEnable &&
                Objects.equals(roleName, that.roleName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleId, roleName, roleNotEnable);
    }
}
