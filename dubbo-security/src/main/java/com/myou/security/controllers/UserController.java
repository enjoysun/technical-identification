package com.myou.security.controllers;

import com.myou.security.entities.UserEntity;
import com.myou.security.models.vo.UserVO;
import com.myou.security.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @Author myou
 * @Date 2020/8/14  5:37 下午
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public UserEntity create(@RequestBody UserVO userVO) {
        UserEntity entityList = userService.findByName(userVO.getUserName());
        if (null != entityList) {
            throw new RuntimeException("用户已存在");
        }
        return userService.create(userVO);
    }

    @PutMapping
    public UserEntity update(@RequestBody UserVO userVO) {
        return userService.update(userVO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        userService.delete(id);
        return;
    }

    @GetMapping("/{id}")
    @ResponseBody
    public UserEntity findById(@PathVariable Long id) {
        UserEntity userEntity = userService.findById(id);
        if (null == userEntity) {
            throw new RuntimeException("用户不存在");
        }
        return userEntity;
    }

    @GetMapping("/list")
    public List<UserEntity> findByEx(UserVO userVO) {
        return userService.findByEx(userVO);
    }
}
