package com.myou.security.configurations;

import com.myou.security.models.Result;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;


/**
 * @Author myou
 * @Date 2020/8/5  4:01 下午
 */
@RestControllerAdvice
public class ResponseBodyConfig implements ResponseBodyAdvice<Object> {

    private final static String packagePath = "com.myou.security.controllers";

    /**
     * 过滤返回Void、String、Result、非packagePath包下
     */
    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        return !methodParameter.getMethod().getReturnType().isAssignableFrom(Void.class)
                && !methodParameter.getMethod().getReturnType().isAssignableFrom(String.class)
                && !methodParameter.getMethod().getReturnType().isAssignableFrom(Result.class)
                && methodParameter.getDeclaringClass().getPackage().getName().contains(packagePath);
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        if (o instanceof Result) {
            return o;
        }
        return new Result("执行成功", HttpStatus.OK, o);
    }
}
