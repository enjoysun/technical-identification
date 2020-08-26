package com.myou.security.controllers;

import com.myou.security.entities.MenuEntity;
import com.myou.security.models.vo.MenuVO;
import com.myou.security.repositorys.MenuRepository;
import com.myou.security.services.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author myou
 * @Date 2020/8/12  11:30 上午
 */
@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping("/{id}")
    public MenuEntity findByID(@PathVariable Long id) {
        return menuService.findById(id);
    }

    @PostMapping
    public MenuEntity create(@RequestBody MenuEntity menuEntity) {
        return menuService.save(menuEntity);
    }

    @PutMapping
    public MenuEntity update(@RequestBody MenuEntity menuEntity) {
        return menuService.save(menuEntity);
    }

    @DeleteMapping("/{id}")
    public void destroy(@PathVariable Long id) {
        menuService.deleteById(id);
    }

    @GetMapping("/list")
    public List<MenuEntity> findByExample(MenuVO menuVO) {
        return menuService.findByEx(menuVO);
    }
}
