package com.myou.security.controllers;

import com.myou.security.entities.RoleEntity;
import com.myou.security.models.vo.RoleVO;
import com.myou.security.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author myou
 * @Date 2020/8/14  10:59 上午
 */
@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping
    public RoleEntity create(@RequestBody RoleVO roleVO) {
        return roleService.roleCreate(roleVO);
    }

    @PutMapping
    public RoleEntity update(@RequestBody RoleVO roleVO) {
        return roleService.roleUpdate(roleVO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        roleService.roleDelete(id);
    }

    @GetMapping("/list")
    public List<RoleEntity> findByEx(RoleVO roleVO) {
        return roleService.roleFindByEx(roleVO);
    }

    @GetMapping("/{id}")
    public RoleEntity findById(@PathVariable Long id) {
        return roleService.findById(id);
    }
}
