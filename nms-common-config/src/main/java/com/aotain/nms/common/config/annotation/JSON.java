package com.aotain.nms.common.config.annotation;

/**
 * Demo class
 *
 * @author bang
 * @date 2019/04/23
 */

import java.lang.annotation.*;

/**
 * 自定义JSON注解
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(JSONS.class)
public @interface JSON {

    Class<?> type();

    String[] include() default {};

    String[] filter() default {};

}
