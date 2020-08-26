package com.myou.security.persistence;

import com.myou.security.entities.MenuEntity;
import com.myou.security.models.vo.MenuVO;
import org.springframework.cglib.beans.BeanCopier;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author myou
 * @Date 2020/8/6  10:26 上午
 */
public class Constants {
    public final static ConcurrentHashMap<String, BeanCopier> BEAN_COPIERS = new ConcurrentHashMap<>();

    private static String getBeanCopierKey(Class<?> src, Class<?> dest) {
        return String.format("%s:%s", src.getName(), dest.getName());
    }

    public static void copy(Object src, Object dest) {
        String key = Constants.getBeanCopierKey(src.getClass(), dest.getClass());
        BeanCopier beanCopier;
        if (Constants.BEAN_COPIERS.containsKey(key)) {
            beanCopier = Constants.BEAN_COPIERS.get(key);
        } else {
            beanCopier = BeanCopier.create(src.getClass(), dest.getClass(), false);
            Constants.BEAN_COPIERS.put(key, beanCopier);
        }
        beanCopier.copy(src, dest, null);
    }
}
