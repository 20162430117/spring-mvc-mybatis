package com.qbian.common.annotation;

import java.lang.annotation.*;

/**
 * 插入数据时自动生成 uuid
 * Created by qbian on 17/4/22.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface UUID {
}
