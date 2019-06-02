package com.example.demo.util;

import java.lang.reflect.Field;

/**
 * ClassUtils
 *
 * @author liujinliang
 * @date 2019/5/20
 **/
public class ClassUtils {
    public static void setProperty(Object bean, String name, Object value){
        try {
            Class beanClass = bean.getClass();
            Field declaredField = beanClass.getDeclaredField(name);
            declaredField.setAccessible(true);
            declaredField.set(bean, value);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
