package com.imooc.demo.annotion;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
//Retention 标记该注解在什么时候起作用  runtime是运行时
@Retention(RetentionPolicy.RUNTIME)
public @interface Table {
    String value();
}
