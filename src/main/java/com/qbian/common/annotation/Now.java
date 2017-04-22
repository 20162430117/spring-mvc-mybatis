package com.qbian.common.annotation;

import java.lang.annotation.*;

/**
 * 保存和更新数据的注解
 * Created by qbian on 17/4/22.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Now {
    String type() default "C";
}
