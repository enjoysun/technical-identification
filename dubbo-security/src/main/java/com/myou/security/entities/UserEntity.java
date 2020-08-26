package com.myou.security.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

/**
 * @Author myou
 * @Date 2020/8/5  5:23 下午
 */
@Entity
@Table(name = "tb_user", schema = "sercurty_auth", catalog = "")
public class UserEntity extends BaseEntity {
    private Long userId;
    private String userName;
    private Boolean userGender;
    private Integer userAge;
    private String userMobile;
    private String userImg;
    private String userPassword;
    private Boolean userNotEnable;

    @Id
    @Column(name = "user_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "user_name", nullable = false, length = 64)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "user_gender", nullable = false)
    public Boolean getUserGender() {
        return userGender;
    }

    public void setUserGender(Boolean userGender) {
        this.userGender = userGender;
    }

    @Basic
    @Column(name = "user_age", nullable = true)
    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    @Basic
    @Column(name = "user_mobile", nullable = false, length = 11)
    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    @Basic
    @Column(name = "user_img", nullable = true, length = 128)
    public String getUserImg() {
        return userImg;
    }

    public void setUserImg(String userImg) {
        this.userImg = userImg;
    }

    @Basic
    @Column(name = "user_password", nullable = false, length = 128)
    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Basic
    @Column(name = "user_not_enable", nullable = false)
    public Boolean getUserNotEnable() {
        return userNotEnable;
    }

    public void setUserNotEnable(Boolean userNotEnable) {
        this.userNotEnable = userNotEnable;
    }

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "user_role",
            joinColumns = {@JoinColumn(name = "sys_user_id", referencedColumnName = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "sys_role_id", referencedColumnName = "role_id")}
    )
    public Set<RoleEntity> getRoleEntities() {
        return roleEntities;
    }

    public void setRoleEntities(Set<RoleEntity> roleEntities) {
        this.roleEntities = roleEntities;
    }

    private Set<RoleEntity> roleEntities;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return userId == that.userId &&
                userGender == that.userGender &&
                userNotEnable == that.userNotEnable &&
                Objects.equals(userName, that.userName) &&
                Objects.equals(userAge, that.userAge) &&
                Objects.equals(userMobile, that.userMobile) &&
                Objects.equals(userImg, that.userImg) &&
                Objects.equals(userPassword, that.userPassword);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userName, userGender, userAge, userMobile, userImg, userPassword, userNotEnable);
    }
}
