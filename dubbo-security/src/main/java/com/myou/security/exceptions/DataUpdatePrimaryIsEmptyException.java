package com.myou.security.exceptions;

/**
 * @Author myou
 * @Date 2020/8/14  5:21 下午
 */
public class DataUpdatePrimaryIsEmptyException extends RuntimeException {
    public DataUpdatePrimaryIsEmptyException(String message) {
        super(message);
    }
}
