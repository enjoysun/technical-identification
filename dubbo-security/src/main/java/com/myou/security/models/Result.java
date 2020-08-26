package com.myou.security.models;

import org.springframework.http.HttpStatus;

import java.util.List;

/**
 * @Author myou
 * @Date 2020/8/5  3:30 下午
 */
public class Result {
    private HttpStatus status;
    private String message;
    private Object data;

    public Result(String message, HttpStatus status, Object data) {
        this.message = message;
        this.status = status;
        this.data = data;
    }

    public Result(HttpStatus status) {
        this("", status, null);
    }

    public Result(HttpStatus status, Object data) {
        this("", status, data);
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
