package com.myou.security.jwt;

import com.myou.security.jwt.domain.UserDesc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * @Author myou
 * @Date 2020/8/17  3:12 下午
 */
public class JwtUserDetail implements UserDetails {


    private UserDesc userDesc;

    @Autowired
    private JwtOperationManual jwtOperationManual;

    public JwtUserDetail(UserDesc userDesc) {
        this.userDesc = userDesc;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return userDesc.getAuthorities();
    }

    @Override
    public String getPassword() {
        return userDesc.getPass();
    }

    @Override
    public String getUsername() {
        return userDesc.getName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return jwtOperationManual.isTokenExpired("");
    }

    @Override
    public boolean isEnabled() {
        return userDesc.getEnable();
    }
}
