package com.myou.security.controllers;

import com.myou.security.entities.ActionEntity;
import com.myou.security.models.vo.ActionVO;
import com.myou.security.services.ActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author myou
 * @Date 2020/8/5  11:46 上午
 */
@RestController
@RequestMapping("/action")
public class ActionController {

    @Autowired
    private ActionService actionService;

    @PostMapping
    public ActionEntity createAction(@RequestBody ActionEntity entity) {
        return actionService.save(entity);
    }

    @GetMapping("/{id}")
    public ActionEntity findById(@PathVariable("id") Long id) {
        return actionService.findById(id);
    }

    @GetMapping("/list")
    public List<ActionEntity> findByEx(ActionVO actionVO) {
        return actionService.findByEx(actionVO);
    }

    @PutMapping
    public ActionEntity update(@RequestBody ActionEntity actionEntity) {
        return actionService.save(actionEntity);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        actionService.deleteById(id);
    }
}
