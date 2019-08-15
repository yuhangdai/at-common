package com.aotain.nms.common.config.annotation;

/**
 * Demo class
 *
 * @author bang
 * @date 2019/05/07
 */

import com.aotain.nms.common.config.log.LogType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 操作日志注解，系统将自动读取配置了该注解的方法，并根据注解信息添加日志
 * @author yinzf
 * @createtime 2014年9月30日 下午2:48:41
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface LogAction {

    /**
     * 操作模块
     * @return
     */
    String module() default "";

    /**
     * 操作类型
     * @return
     */
    LogType type() default LogType.READ;

    /**
     * 操作描述
     * @return
     */
    String description() default "";

    /**
     * 操作数据关键信息(可包含多个)
     * @return
     */
    String dataJson() default "";

    /**
     * 日志类型
     * @return
     */
//    int logType() default 1;

}
