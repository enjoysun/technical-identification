package com.myou.security.models.dto;

/**
 * @Author myou
 * @Date 2020/8/17  5:25 下午
 */
public class UserDTO {
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Boolean getUserGender() {
        return userGender;
    }

    public void setUserGender(Boolean userGender) {
        this.userGender = userGender;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    public String getUserImg() {
        return userImg;
    }

    public void setUserImg(String userImg) {
        this.userImg = userImg;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Boolean getUserNotEnable() {
        return userNotEnable;
    }

    public void setUserNotEnable(Boolean userNotEnable) {
        this.userNotEnable = userNotEnable;
    }

    private Long userId;
    private String userName;
    private Boolean userGender;
    private Integer userAge;
    private String userMobile;
    private String userImg;
    private String userPassword;
    private Boolean userNotEnable;
}
