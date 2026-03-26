package com.chd.types.annotations;

import java.lang.annotation.*;

/**
 * @className: DCCValue
 * @author: powfu
 * @date: 26/3/2026 下午5:01
 * @Version: 1.0
 * @description:
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Documented
public @interface DCCValue {

    String value() default "";
}
