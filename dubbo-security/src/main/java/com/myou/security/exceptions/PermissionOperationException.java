package com.myou.security.exceptions;

/**
 * @Author myou
 * @Date 2020/8/10  4:30 下午
 * 非受异常检查类
 */
public class PermissionOperationException extends RuntimeException {
    public PermissionOperationException(String message) {
        super(message);
    }
}
