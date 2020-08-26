package com.myou.security.controllers;

import com.myou.security.entities.PermissionEntity;
import com.myou.security.models.vo.PermissionVO;
import com.myou.security.services.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author myou
 * @Date 2020/8/10  5:08 下午
 */
@RestController
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    @PostMapping
    public List<PermissionEntity> create(@RequestBody PermissionVO permissionVO) {
        ArrayList<PermissionVO> arrayList = new ArrayList<>();
        arrayList.add(permissionVO);
        return permissionService.permissionCreate(arrayList);
    }

    @PutMapping
    public PermissionEntity update(@RequestBody PermissionVO permissionVO) {
        return permissionService.permissionUpdate(permissionVO);
    }

    @DeleteMapping("/{id}")
    public boolean destroy(@PathVariable Long id) {
        return permissionService.permissionDestroy(id);
    }

    @GetMapping("/{id}")
    public PermissionEntity findByID(@PathVariable Long id) {
        return permissionService.permissionFind(id);
    }

    @GetMapping("/list")
    public List<PermissionEntity> findAll(@RequestParam("id") List<Long> ids){
        return permissionService.permissionFindList(ids);
    }
}
