package com.myou.security.models.vo;

import com.myou.security.models.PageInfo;

import java.util.Set;

/**
 * @Author myou
 * @Date 2020/8/14  4:43 下午
 */
public class UserVO extends PageInfo {
    private Long userId;
    private String userName;
    private Boolean userGender;
    private Integer userAge;
    private String userMobile;
    private String userImg;
    private String userPassword;

    public Set<Long> getRateIds() {
        return rateIds;
    }

    public void setRateIds(Set<Long> rateIds) {
        this.rateIds = rateIds;
    }

    private Set<Long> rateIds;

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

    private Boolean userNotEnable;
}
