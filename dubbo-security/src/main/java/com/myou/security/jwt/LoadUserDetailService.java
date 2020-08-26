package com.myou.security.jwt;

import com.myou.security.entities.UserEntity;
import com.myou.security.jwt.domain.UserDesc;
import com.myou.security.services.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;

/**
 * @Author myou
 * @Date 2020/8/17  3:16 下午
 */
@Service
public class LoadUserDetailService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        if (StringUtils.isEmpty(s)) {
            throw new UsernameNotFoundException("用户名为空");
        }
        UserEntity userEntity = userService.findByName(s);
        if (null == userEntity) {
            throw new UsernameNotFoundException("不存在该用户");
        }
        HashSet<GrantedAuthority> authorities = new HashSet<>();
        userEntity.getRoleEntities().forEach(item -> {
            authorities.add(new CustomGrantedAuthority(item));
        });
        UserDesc userDesc = new UserDesc();
        userDesc.setName(userEntity.getUserName());
        userDesc.setEnable(userEntity.getUserNotEnable());
        userDesc.setPass(userEntity.getUserPassword());
        userDesc.setAuthorities(authorities);
        JwtUserDetail jwtUserDetail = new JwtUserDetail(userDesc);
        return jwtUserDetail;
    }
}
