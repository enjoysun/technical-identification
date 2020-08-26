package com.myou.consumer.service;

import com.alibaba.dubbo.config.annotation.Service;
import service.FooService;

/**
 * @Author myou
 * @Date 2020/7/31  5:06 下午
 */
@Service
public class FooImpl implements FooService {
    @Override
    public String foo(String string) {
        return String.format("%s-ip", string);
    }
}
