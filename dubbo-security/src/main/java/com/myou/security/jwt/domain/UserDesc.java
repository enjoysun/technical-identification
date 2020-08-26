package com.myou.security.jwt.domain;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * @Author myou
 * @Date 2020/8/17  4:03 下午
 */
public class UserDesc {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Authorities;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        Authorities = authorities;
    }

    private String name;
    private String pass;
    private Boolean enable;
    private Collection<? extends GrantedAuthority> Authorities;
}
