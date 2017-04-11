package com.testng;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * Created by November on 29.03.2017.
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface NeedFreshDriver {

    DriverType[] value() default {DriverType.ALL};

    String reason() default ("For unknown reason");
}
